package softuni.server.parser;

import softuni.server.http.HttpRequestMethod;
import softuni.server.provider.ClassProvider;
import softuni.server.routing.Controller;
import softuni.server.routing.ControllerActionPair;
import softuni.server.routing.RequestMapping;
import softuni.server.routing.UriParameter;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerAnnotationParser implements
        AnnotationParser<HttpRequestMethod, Map<String, ControllerActionPair>> {

    private final ClassProvider classProvider;

    public ControllerAnnotationParser(ClassProvider classProvider) {
        this.classProvider = classProvider;
    }

    @Override
    public void parse(Map<HttpRequestMethod, Map<String, ControllerActionPair>> routes) throws
            IllegalAccessException, InstantiationException {
        Class[] classes = this.classProvider.getClassesByAnnotation(Controller.class);

        for (Class currentClass : classes) {

            for (Method currentMethod : Arrays.stream(currentClass
            .getDeclaredMethods())
            .filter(method -> method.isAnnotationPresent(RequestMapping.class))
            .toArray(Method[]::new)) {

                RequestMapping requestMapping = currentMethod.getAnnotation(RequestMapping.class);

                HttpRequestMethod requestMethod = requestMapping.method();
                String url = requestMapping.value();
                List<String> urlTokens = Arrays.stream(url.split("/"))
                        .collect(Collectors.toList());
                Map<Integer, Class> argumentMapping = new HashMap<>();

                url = this.createMappingRegex(currentMethod, url, urlTokens, argumentMapping);

                Object controllerInstance = currentClass.newInstance();

                ControllerActionPair actionPair = new ControllerActionPair(currentMethod,
                        controllerInstance, argumentMapping);

                if (!routes.containsKey(requestMethod)) {
                    routes.put(requestMethod, new HashMap<>());
                }

                routes.get(requestMethod).put(url, actionPair);
            }
        }
    }

    private String createMappingRegex(Method currentMethod,
                                      String mapping,
                                      List<String> mappingTokens,
                                      Map<Integer, Class> argumentMapping) {
        for (int i = 0; i < mappingTokens.size(); i++) {
            if (!(mappingTokens.get(i).startsWith("{")) && mappingTokens.get(i).endsWith("}")) {
                continue;
            }

            for (Parameter parameter : currentMethod.getParameters()) {
                if (!parameter.isAnnotationPresent(UriParameter.class)) {
                    continue;
                }

                UriParameter uriParameter = parameter.getAnnotation(UriParameter.class);
                if (mappingTokens.get(i).equals("{" + uriParameter.value() + "}")) {
                    argumentMapping.put(i, parameter.getType());

                    String regexReplacement = parameter.getType() == String.class
                            ? "[a-zA-Z]+"
                            : "[0-9]+";
                    mapping = mapping.replace(mappingTokens.get(i), regexReplacement);
                    break;
                }
            }
        }
        return "^" + mapping + "$";
    }
}

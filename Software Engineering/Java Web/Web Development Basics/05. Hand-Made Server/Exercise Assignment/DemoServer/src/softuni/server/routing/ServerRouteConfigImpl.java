package softuni.server.routing;

import softuni.server.handler.GetHandler;
import softuni.server.handler.PostHandler;
import softuni.server.handler.RequestHandlerImpl;
import softuni.server.http.HttpRequestMethod;
import softuni.server.parser.ControllerAnnotationParser;
import softuni.server.provider.ClassProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by s_she on 09.2.2017 г..
 */
public class ServerRouteConfigImpl implements ServerRouteConfig {

    private final Map<HttpRequestMethod, Map<String, RoutingContext>> routes;
    private final ClassProvider classProvider;

    public ServerRouteConfigImpl(ClassProvider classProvider) throws IllegalAccessException, InstantiationException {
        this.classProvider = classProvider;
        this.routes = new HashMap<>();

        for (HttpRequestMethod httpRequestMethod : HttpRequestMethod.values()) {
            this.routes.put(httpRequestMethod, new HashMap<>());
        }

        this.initializeServerConfig();
    }

    private void initializeServerConfig() throws InstantiationException, IllegalAccessException {
        Map<HttpRequestMethod, Map<String, ControllerActionPair>> annotationRoutes = new HashMap<>();

        ControllerAnnotationParser annotationParser = new ControllerAnnotationParser(this.classProvider);

        annotationParser.parse(annotationRoutes);

        for (Map.Entry<HttpRequestMethod, Map<String, ControllerActionPair>> mapEntry : annotationRoutes.entrySet()) {
            for (Map.Entry<String, ControllerActionPair> actionPairEntry : mapEntry.getValue().entrySet()) {
                RequestHandlerImpl handler;
                if (mapEntry.getKey() == HttpRequestMethod.GET) {
                    handler = new GetHandler();
                } else {
                    handler = new PostHandler();
                }

                Map<Integer, Class> args = actionPairEntry.getValue().getArgumentMapping();
                ControllerActionPair actionPair = actionPairEntry.getValue();

                RoutingContext routingContext = new RoutingContextImpl(handler, args, actionPair);

                this.routes.get(mapEntry.getKey()).put(actionPairEntry.getKey(), routingContext);
            }
        }
    }

    @Override
    public Map<HttpRequestMethod, Map<String, RoutingContext>> getRoutes() {
        return this.routes;
    }
}

package softuni.server.provider;

import softuni.server.util.DirectoryViewer;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassProviderImpl implements ClassProvider {

    private Class[] classes;

    private Map<Class, Class[]> classesByAnnotation;

    public ClassProviderImpl() throws IOException, ClassNotFoundException {
        this.classes = DirectoryViewer.findControllers(
                System.getProperty("user.dir", "/out/production/DemoServer/softuni/app"));

        this.classesByAnnotation = new HashMap<>();
    }

    @Override
    public Class[] getClassesByAnnotation(Class annotation) {
        if (this.classesByAnnotation.containsKey(annotation)) {
            return this.classesByAnnotation.get(annotation);
        }

        Class[] result = Arrays.stream(this.classes)
                .filter(c -> c.isAnnotationPresent(annotation))
                .toArray(Class[]::new);

        this.classesByAnnotation.put(annotation ,result);

        return result;
    }
}

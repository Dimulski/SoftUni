package softuni.server.util;

import softuni.server.routing.Controller;

import java.io.File;
import java.util.*;

public class DirectoryViewer {

    public static Class[] findControllers(String initialPathStr) throws ClassNotFoundException {
        List<File> classes = getClasses(initialPathStr);

        List<Class> controllers = new LinkedList<>();

        for (File file : classes) {
            String fileName = file
                    .getAbsolutePath()
                    .split("DemoServer")[2]
                    .replace("\\", ".");

            Class clazz = Class.forName(fileName.substring(1, fileName.length() - 6));

            if (clazz.isAnnotationPresent(Controller.class)) {
                controllers.add(clazz);
            }
        }

        return controllers.toArray(new Class[0]);
    }

    private static List<File> getClasses(String initialPathStr) {
        Deque<File> dirs = new ArrayDeque<>();
        List<File> classes = new ArrayList<>();

        File root = new File(initialPathStr);
        dirs.offer(root);

        while (!dirs.isEmpty()) {
            File currFile = dirs.poll();

            for (File file : currFile.listFiles()) {
                if (file.isDirectory()) {
                    dirs.offer(file);
                    continue;
                }
                if (!file.getName().contains(".class")) {
                    continue;
                }

                classes.add(file);
            }
        }

        return classes;
    }
}

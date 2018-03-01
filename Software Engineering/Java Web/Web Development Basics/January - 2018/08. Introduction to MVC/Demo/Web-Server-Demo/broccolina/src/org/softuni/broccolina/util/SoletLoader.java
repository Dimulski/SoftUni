package org.softuni.broccolina.util;

import org.softuni.broccolina.solet.HttpSolet;
import org.softuni.broccolina.solet.WebSolet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SoletLoader {
    public final String APPLICATION_FOLDER_PATH;

    private HashMap<String, HttpSolet> loadedSoletsByApplicationName;

    public SoletLoader(String serverRootPath) {
        this.APPLICATION_FOLDER_PATH =
                serverRootPath + "apps";
    }

    private boolean isLibraryFile(File file) {
        return file.getName().endsWith(".jar");
    }

    private void loadLibrary(JarFile library, String canonicalPath) {
        Enumeration<JarEntry> fileEntries = library.entries();

        try {
            URL[] urls = {new URL("jar:file:" + canonicalPath + "!/")};
            URLClassLoader ucl = URLClassLoader.newInstance(urls);

            while (fileEntries.hasMoreElements()) {
                JarEntry currentFile = fileEntries.nextElement();

                if (currentFile.isDirectory()
                        || !currentFile.getName().endsWith(".class")) continue;

                String className = currentFile.getName()
                        .replace(".class", "")
                        .replace("/", ".");

                Class soletClazz = ucl.loadClass(className);

                if (HttpSolet.class.isAssignableFrom(soletClazz)) {
                    HttpSolet soletObject =
                            (HttpSolet) soletClazz.getConstructor()
                                    .newInstance();

                    String applicationPath = new File(canonicalPath).getParent();

                    this.loadedSoletsByApplicationName
                            .putIfAbsent(applicationPath
                                            .substring(applicationPath.lastIndexOf("\\") + 1)
                                            + soletObject.getClass()
                                            .getAnnotation(WebSolet.class).route()
                                    , soletObject);
                }
            }
        } catch (MalformedURLException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void loadLibraries(String libFolderPath) throws IOException {
        File libDirectory = new File(libFolderPath);

        if (libDirectory.exists() && libDirectory.isDirectory()) {
            for (File file : libDirectory.listFiles()) {
                if (!this.isLibraryFile(file)) {
                    continue;
                }

                JarFile library = new JarFile(file.getCanonicalPath());
                this.loadLibrary(library, file.getCanonicalPath());
            }
        }
    }

    public Map<String, HttpSolet> getSolets() {
        return Collections.unmodifiableMap(this.loadedSoletsByApplicationName);
    }

    public void loadSolets() {
        this.loadedSoletsByApplicationName = new HashMap<>();

        try {
            File appsDir = new File(APPLICATION_FOLDER_PATH);

            if (!appsDir.exists()) return;

            for (File file : appsDir.listFiles()) {
                this.loadLibraries(file.getCanonicalPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

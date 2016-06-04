import java.io.File;
import java.util.LinkedList;

/**
 * Created by User on 4.6.2016 г..
 */
public class IOManager {

    public static void traverseDirectory(String path) {
        // TODO: Try-catch for access exception
        LinkedList<File> subfolders = new LinkedList<>();
        File root = new File(path);

        subfolders.add(root);

        while (subfolders.size() != 0) {
            File currentFolder = subfolders.removeFirst();

            if (currentFolder.listFiles() != null) {
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()) {
                        traverseDirectory(file.getPath());
                    }
                }
            }

            OutputWriter.writeMessage(currentFolder.getPath());
        }
//        } catch (AccessDeniedException ex) {
//            OutputWriter.displayException("Access denied");
//        }
    }
}

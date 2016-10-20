package Problem5GetFolderSize;

import java.io.File;

/**
 * Created by User on 8.6.2016 г..
 */
public class GetFolderSize {

    public static void main(String[] args) {

        File folder = new File("resources\\TestFolder");
        long folderSize = 0L;
        for (File file : folder.listFiles()) {
            if (!file.isDirectory()) {
                folderSize += file.length();
            }
        }
        System.out.println(folderSize / 1000000.0);
    }
}

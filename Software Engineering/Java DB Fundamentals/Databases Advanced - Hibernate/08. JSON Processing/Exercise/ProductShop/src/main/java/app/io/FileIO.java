package app.io;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class FileIO {

    public void write(String content, String fileName) throws IOException {
        try (OutputStream outputStream = new FileOutputStream(fileName);
             BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(outputStream))
        ) {
            bfw.write(content);
        }
    }

    public String read(String filename) throws IOException {
        StringBuilder fileContent = new StringBuilder();
        try (InputStream inputStream = getClass().getResourceAsStream(filename);
             BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream))
        ) {
            String line;
            while ((line = bfr.readLine()) != null) {
                fileContent.append(line);
            }
        }

        return fileContent.toString();
    }
}

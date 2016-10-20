package Problem2LineNumbers;

import java.io.*;

/**
 * Created by User on 8.6.2016 г..
 */
public class LineNumbers {

    public static void main(String[] args) throws IOException {

        File input = new File("resources\\Problem2LineNumbers\\03_LinesIn.txt");
        File output = new File("resources\\Problem2LineNumbers\\03_LinesOut.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null) {
                writer.write(++counter + ". " + line);
                writer.newLine();
            }
        }
    }
}

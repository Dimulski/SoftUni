package Problem1OddLines;

import java.io.*;

/**
 * Created by User on 8.6.2016 г..
 */
public class OddLines {

    public static void main(String[] args) throws IOException {

        File input = new File("resources\\Problem1OddLines\\03_OddLinesIn.txt");
        File output = new File("resources\\Problem1OddLines\\03_OddLinesOut.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {

            reader.readLine(); // The first line is apparently not odd because "Line numbers starts from 0."
            String oddLine;
            while ((oddLine = reader.readLine()) != null) {
                writer.write(oddLine);
                writer.newLine();
                reader.readLine();
            }

        }
    }
}

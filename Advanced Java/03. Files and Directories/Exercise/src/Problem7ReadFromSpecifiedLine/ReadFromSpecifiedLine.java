package Problem7ReadFromSpecifiedLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by User on 8.6.2016 г..
 */
public class ReadFromSpecifiedLine {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int linesToSkip = Integer.parseInt(scanner.nextLine());
        try (BufferedReader reader = new BufferedReader(new FileReader("resources\\Problem1OddLines\\01_OddLinesIn.txt"))) {
            for (int i = 0; i < linesToSkip; i++) {
                reader.readLine();
            }
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

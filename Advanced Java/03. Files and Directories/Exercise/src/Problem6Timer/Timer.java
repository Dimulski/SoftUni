package Problem6Timer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 8.6.2016 г..
 */
public class Timer {

    public static void main(String[] args) throws IOException {

        try (BufferedReader firstReader = new BufferedReader(new FileReader("resources\\Problem1OddLines\\01_OddLinesIn.txt"));
             BufferedReader secondReader = new BufferedReader(new FileReader("resources\\Problem1OddLines\\01_OddLinesOut.txt"))) {
            long startTime = System.nanoTime();
            while ((firstReader.readLine()) != null) {
            }
            long firstDuration = System.nanoTime() - startTime;

            while ((secondReader.readLine()) != null) {
            }
            long secondDuration = System.nanoTime() - (startTime + firstDuration);

            if (firstDuration < secondDuration) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        }
    }
}

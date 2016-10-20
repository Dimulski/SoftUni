package Problem4FindEvensOrOdds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;

/**
 * Created by User on 18.6.2016 г..
 */
public class FindEvensOrOdds {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] range = reader.readLine().split("\\s+");
        Integer lowerBorder = Integer.valueOf(range[0]);
        Integer upperBorder = Integer.valueOf(range[1]);
        Integer[] numbers = new Integer[upperBorder - lowerBorder + 1];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = lowerBorder + i;
        }

        String command = reader.readLine();

        if (command.equals("even")) {
            filter(numbers, x -> x % 2 == 0);
        } else if (command.equals("odd")) {
            filter(numbers, x -> x % 2 != 0);
        }
    }

    private static void filter(Integer[] numbers, Predicate<Integer> predicate) {
        for (Integer number : numbers) {
            if (predicate.test(number)) {
                System.out.printf("%s ", number);
            }
        }
    }
}

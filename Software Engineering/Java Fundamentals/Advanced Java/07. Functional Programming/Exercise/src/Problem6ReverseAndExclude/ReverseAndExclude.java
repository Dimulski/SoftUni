package Problem6ReverseAndExclude;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by User on 18.6.2016 г..
 */
public class ReverseAndExclude {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(string -> Integer.valueOf(string))
                .collect(Collectors.toList());

        Integer divider = Integer.valueOf(reader.readLine());

        numbers = filterNumbers(numbers, num -> num % divider == 0);
        Collections.reverse(numbers);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static List<Integer> filterNumbers(List<Integer> numbers, Predicate<Integer> tester) {
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            if (! tester.test(number)) {
                result.add(number);
            }
        }
        return result;
    }
}

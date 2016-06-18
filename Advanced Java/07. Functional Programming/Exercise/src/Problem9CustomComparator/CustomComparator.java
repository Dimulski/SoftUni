package Problem9CustomComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by User on 18.6.2016 г..
 */
public class CustomComparator {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .map(string -> Integer.valueOf(string))
                .collect(Collectors.toList());

        Comparator<Integer> customComparator = (n1, n2) -> {
            if (n1 % 2 == 0 && n2 % 2 != 0) {
                return -1;
            } else if (n1 % 2 != 0 && n2 % 2 == 0) {
                return 1;
            } else {
                // return n1.compareTo(n2) // We do not need a custom comparator here. We can just use the built in one.
                if (n1 > n2) {
                    return 1;
                } else if (n1 < n2) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };

        Collections.sort(numbers, customComparator);
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}

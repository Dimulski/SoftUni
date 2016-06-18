package Problem3CustomMinFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

/**
 * Created by User on 18.6.2016 г..
 */
public class CustomMinFunction {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Integer[] numbers = new Integer[input.length];
        int counter = 0;
        for (String num : input) {
            numbers[counter++] = Integer.parseInt(num);
        }
        System.out.println(findMin.apply(numbers));
    }

    private static Function<Integer[], Integer> findMin = new Function<Integer[], Integer>() {
        @Override
        public Integer apply(Integer[] numbers) {
            if (numbers.length == 0) {
                return null;
            }
            Integer min = Integer.MAX_VALUE;
            for (Integer num : numbers) {
                if (num < min) {
                    min = num;
                }
            }
            return min;
        }
    };
}

package Problem1ConsumerPrint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * Created by User on 18.6.2016 г..
 */
public class Problem1ConsumerPrint {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Consumer<String> print = message -> System.out.println(message);
        for (String name : input) {
            print.accept(name);
        }

    }
}

package Problem2KnightsOfHonor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

/**
 * Created by User on 18.6.2016 г..
 */
public class KnightsOfHonor {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        Consumer<String> printSir = message -> System.out.println("Sir " + message);
        for (String name : input) {
            printSir.accept(name);
        }
    }
}

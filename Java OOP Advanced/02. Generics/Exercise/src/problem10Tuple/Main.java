package problem10Tuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        Tuple<String, String> first = new Tuple<>(String.format("%s %s", input[0], input[1]), input[2]);
        System.out.println(first);

        input = reader.readLine().split("\\s+");
        Tuple<String, Integer> second = new Tuple<>(input[0], Integer.parseInt(input[1]));
        System.out.println(second);

        input = reader.readLine().split("\\s+");
        Tuple<Integer, Double> third = new Tuple<>(Integer.parseInt(input[0]), Double.parseDouble(input[1]));
        System.out.println(third);
    }
}

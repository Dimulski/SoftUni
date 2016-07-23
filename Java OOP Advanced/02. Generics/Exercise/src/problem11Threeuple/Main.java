package problem11Threeuple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputParams = reader.readLine().split("\\s+");
        String name = String.format("%s %s", inputParams[0], inputParams[1]);
        Threeuple<String, String, String> first = new Threeuple<>(name, inputParams[2], inputParams[3]);
        System.out.println(first);

        inputParams = reader.readLine().split("\\s+");
        boolean state = inputParams[2].equals("drunk");
        Threeuple<String, Integer, Boolean> second = new Threeuple<>(inputParams[0], Integer.parseInt(inputParams[1]), state);
        System.out.println(second);

        inputParams = reader.readLine().split("\\s+");
        Threeuple<String, Double, String> third = new Threeuple<>(inputParams[0], Double.parseDouble(inputParams[1]), inputParams[2]);
        System.out.println(third);
    }
}

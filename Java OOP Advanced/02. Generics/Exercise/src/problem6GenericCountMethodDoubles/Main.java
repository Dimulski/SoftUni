package problem6GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        List<Double> elements = new ArrayList<Double>();
        for (int i = 0; i < n; i++) {
            elements.add(Double.parseDouble(reader.readLine()));
        }
        Double targetElement = Double.parseDouble(reader.readLine());
        System.out.println(GenericMethods.CountGreaterThan(elements, targetElement));
    }
}

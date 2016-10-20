package problem5GenericCountMethodStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        List<String> elements = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            elements.add(reader.readLine());
        }
        String targetElement = reader.readLine();
        System.out.println(GenericMethods.CountGreaterThat(elements, targetElement));
    }
}

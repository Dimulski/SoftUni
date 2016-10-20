package Problem3TemperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureConverter {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            String[] lineParams = line.split(" ");
            System.out.println(convertTemperature(Integer.parseInt(lineParams[0]), lineParams[1]));
        }
    }

    static String convertTemperature(Integer temperature, String type) {
        switch (type) {
            case "Celsius": {
                double newTemperature = (temperature * (double)9/5) + 32;
                return String.format("%.2f", newTemperature) + " Fahrenheit";
            }
            case "Fahrenheit": {
                double newTemperature = (temperature - 32) * (double)5/9;
                return String.format("%.2f", newTemperature) + " Celsius";
            }
            default: return "Invalid type";
        }
    }
}

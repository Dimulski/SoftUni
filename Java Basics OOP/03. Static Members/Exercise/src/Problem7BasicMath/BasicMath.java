package Problem7BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicMath {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = reader.readLine()).equals("End")) {
            String[] params = line.split(" ");
            switch (params[0]) {
                case "Sum":
                    MathUtil.sum(Double.parseDouble(params[1]), Double.parseDouble(params[2]));
                    break;
                case "Subtract":
                    MathUtil.subtract(Double.parseDouble(params[1]), Double.parseDouble(params[2]));
                    break;
                case "Multiply":
                    MathUtil.multiply(Double.parseDouble(params[1]), Double.parseDouble(params[2]));
                    break;
                case "Divide":
                    MathUtil.divide(Double.parseDouble(params[1]), Double.parseDouble(params[2]));
                    break;
                case "Percentage":
                    MathUtil.percentage(Double.parseDouble(params[1]), Double.parseDouble(params[2]));
                    break;
            }
        }
    }
}

class MathUtil {

    static void sum(Double firstNumber, Double secondNumber) {
        System.out.println(String.format("%.2f", firstNumber + secondNumber));
    }
    static void subtract(Double firstNumber, Double secondNumber) {
        System.out.println(String.format("%.2f", firstNumber - secondNumber));
    }
    static void multiply(Double firstNumber, Double secondNumber) {
        System.out.println(String.format("%.2f", firstNumber * secondNumber));
    }
    static void divide(Double divident, Double divisor) {
        System.out.println(String.format("%.2f", divident / divisor));
    }
    static void percentage(Double totalPercentage, Double percentOfThatNumber) {
        System.out.println(String.format("%.2f", totalPercentage * (percentOfThatNumber / 100)));
    }
}

package Problem3LastDigitName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastDigitName {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Number number = new Number(n);
        System.out.println(number.lastDigitWord());
    }
}

class Number {
    Integer number;

    Number(int number) {
        this.number = number;
    }

    public String lastDigitWord() {
        String num = this.number.toString();
        int digit = Integer.parseInt(num.substring(num.length() - 1));
        switch (digit) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "Invalid number";
        }
    }
}

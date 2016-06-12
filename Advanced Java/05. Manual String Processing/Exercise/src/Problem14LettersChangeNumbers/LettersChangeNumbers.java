package Problem14LettersChangeNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 12.6.2016 г..
 */
public class LettersChangeNumbers {

    public static void main(String[] args) throws IOException {

        int difference = 96;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputParams = reader.readLine().split("\\s+");
        double bigSum = 0;
        for (String word : inputParams) {
            String firstLetter = String.valueOf(word.charAt(0));
            Double number = Double.parseDouble(word.substring(1,word.length() - 1));
            String secondLetter = String.valueOf(word.charAt(word.length() - 1));
            if (Character.isUpperCase(firstLetter.charAt(0))) {
                number /= firstLetter.toLowerCase().hashCode() - difference;
            } else {
                number *= firstLetter.hashCode() - difference;
            }

            if (Character.isUpperCase(secondLetter.charAt(0))) {
                number -= secondLetter.toLowerCase().hashCode() - difference;
            } else {
                number += secondLetter.hashCode() - difference;
            }
            bigSum += number;
        }
        System.out.printf("%.2f", bigSum);
    }
}

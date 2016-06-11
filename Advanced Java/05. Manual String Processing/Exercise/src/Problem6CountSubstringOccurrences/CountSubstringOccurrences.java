package Problem6CountSubstringOccurrences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 11.6.2016 г..
 */
public class CountSubstringOccurrences {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().toLowerCase().split("");
        String[] targetString = reader.readLine().toLowerCase().split("");
        int occurrencesCounter = 0;
        for (int i = 0; i < input.length - targetString.length + 1; i++) {
            if (input[i].equals(targetString[0])) {
                boolean isMatch = true;
                for (int j = 1; j < targetString.length; j++) {
                    if (!input[i + j].equals(targetString[j])) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    occurrencesCounter++;
                }
            }
        }
        System.out.println(occurrencesCounter);
    }
}

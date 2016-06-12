package Problem12CharacterMultiplier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 11.6.2016 г..
 */
public class CharacterMultiplier {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String first = input[0], second = input[1];
        long result = multiplyStrings(first, second);
        System.out.println(result);
    }

    private static long multiplyStrings(String first, String second) {
        long result = 0;
        int shorterLength = Math.min(first.length(), second.length());
        for (int i = 0; i < shorterLength; i++) {
            result += first.charAt(i) * second.charAt(i);
        }
        if (first.length() == second.length()) {
            return result;
        }
        boolean longer;
        longer = first.length() > second.length();
        String longerString = longer ? first : second;
        int remainingLength = Math.abs(first.length() - second.length());
        for (int i = 0; i < remainingLength; i++) {
            result += longerString.charAt(longerString.length() - 1 - i);
        }
        return result;
    }
}

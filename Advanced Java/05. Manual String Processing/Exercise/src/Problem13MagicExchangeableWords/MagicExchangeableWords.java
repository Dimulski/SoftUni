package Problem13MagicExchangeableWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by User on 12.6.2016 г..
 */
public class MagicExchangeableWords {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String first = input[0], second = input[1];
        boolean result = areExchangeable(first, second);
        System.out.println(result);
    }

    private static boolean areExchangeable(String first, String second) {
        
        HashMap<Character, Character> mappedCharsLonger = new HashMap<>();
        HashMap<Character, Character> mappedCharsShorter = new HashMap<>();
        String shorter;
        String longer;
        if (first.length() <= second.length()) {
            shorter = first;
            longer = second;
        } else {
            shorter = second;
            longer = first;
        }
        for (int i = 0; i < shorter.length(); i++) {
            if (!mappedCharsLonger.containsKey(longer.charAt(i))) {
                mappedCharsLonger.put(longer.charAt(i), shorter.charAt(i));
            }
            if (!mappedCharsShorter.containsKey(shorter.charAt(i))) {
                mappedCharsShorter.put(shorter.charAt(i), longer.charAt(i));
            }
            if (mappedCharsLonger.get(longer.charAt(i)) != shorter.charAt(i) ||
                    mappedCharsShorter.get(shorter.charAt(i)) != longer.charAt(i)) {
                return false;
            }
        }
        for (int i = shorter.length(); i < longer.length(); i++) {
            if (!mappedCharsLonger.containsKey(longer.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

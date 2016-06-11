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
        String first = reader.readLine();
        String second = reader.readLine();
        long result = multiplyStrings(first, second);
        System.out.println(result);
    }

    private static long multiplyStrings(String first, String second) {
        return 0;
    }
}

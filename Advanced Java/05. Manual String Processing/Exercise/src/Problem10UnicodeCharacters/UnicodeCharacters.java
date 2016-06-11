package Problem10UnicodeCharacters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 11.6.2016 г..
 */
public class UnicodeCharacters {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String text = reader.readLine();
        for (int i = 0; i < text.length(); i++) {
            result.append(String.format("\\u00%x", (int)text.charAt(i)));
        }
        System.out.println(result);
    }
}

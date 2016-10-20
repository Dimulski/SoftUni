package Problem15MelrahShake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 12.6.2016 г..
 */
public class MelrahShake {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        String pattern = reader.readLine();

        while (true) {

            if (pattern.length() == 0)
            {
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }
            int matchCounter = 0;
            int index = text.indexOf(pattern);
            while (index >= 0)
            {
                matchCounter++;
                index = text.indexOf(pattern, index + pattern.length());
            }
            if (matchCounter < 2)
            {
                System.out.println("No shake.");
                System.out.println(text);
                break;
            }
            int firstIndex = text.indexOf(pattern);
            int lastIndex = text.lastIndexOf(pattern);
            text = text.substring(0, firstIndex) +
                    text.substring(firstIndex + pattern.length(), lastIndex) +
                    text.substring(lastIndex + pattern.length(), text.length());
            int indexToRemove = pattern.length() / 2;
            pattern = pattern.substring(0, indexToRemove) + pattern.substring(indexToRemove + 1, pattern.length());
            System.out.println("Shaked it.");
        }
    }
}

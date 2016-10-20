package Problem9TextFilter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 11.6.2016 г..
 */
public class TextFilter {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] banList = reader.readLine().split(", ");
        String text = reader.readLine();
        for (String bannedWord : banList) {
            text = text.replaceAll(bannedWord, new String(new char[bannedWord.length()]).replace('\0', '*'));
        }
        System.out.println(text);
    }
}

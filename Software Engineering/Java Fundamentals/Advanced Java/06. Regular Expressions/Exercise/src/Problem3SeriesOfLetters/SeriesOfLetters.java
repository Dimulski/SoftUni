package Problem3SeriesOfLetters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 14.6.2016 г..
 */
public class SeriesOfLetters {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String replaced = input.replaceAll("(.)\\1+", "$1");
        System.out.println(replaced);
    }
}

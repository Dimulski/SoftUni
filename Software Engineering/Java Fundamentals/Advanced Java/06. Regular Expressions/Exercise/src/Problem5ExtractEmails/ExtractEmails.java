package Problem5ExtractEmails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 14.6.2016 г..
 */
public class ExtractEmails {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();

        Pattern pattern = Pattern.compile("(?:(?<=\\s)|^)[a-z0-9][a-z0-9\\.\\-\\_]*[a-z0-9]@[a-z0-9][a-z0-9\\-]*[a-z0-9](?:\\.[a-z0-9][a-z0-9\\-]*[a-z0-9])+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

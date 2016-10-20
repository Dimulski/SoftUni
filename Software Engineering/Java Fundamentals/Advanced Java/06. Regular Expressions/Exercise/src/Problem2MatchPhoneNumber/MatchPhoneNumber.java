package Problem2MatchPhoneNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 14.6.2016 г..
 */
public class MatchPhoneNumber {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern pattern = Pattern.compile("(\\+359 \\d \\d{3} \\d{4}\\b|\\+359-\\d-\\d{3}-\\d{4}\\b)");
        String input;
        while (!(input = reader.readLine()).equals("end")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        }
    }
}

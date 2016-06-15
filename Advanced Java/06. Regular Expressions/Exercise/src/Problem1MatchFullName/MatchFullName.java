package Problem1MatchFullName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 14.6.2016 г..
 */
public class MatchFullName {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = reader.readLine()).equals("end")) {
            String regex = "(\\b[A-Z][a-z]+ [A-Z][a-z]+\\b)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher;
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        }

    }

}

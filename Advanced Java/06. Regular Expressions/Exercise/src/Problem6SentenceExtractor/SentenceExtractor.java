package Problem6SentenceExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 14.6.2016 г..
 */
public class SentenceExtractor {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String targetWord = reader.readLine();
        String text = reader.readLine();
        Pattern pattern = Pattern.compile(".+?[!.?]");
        Matcher matcher = pattern.matcher(text);
        ArrayList<String> listOfSentences = new ArrayList<>();
        while (matcher.find()) {
            listOfSentences.add(matcher.group(0));
        }
        String targetWordRegex = "\\b" + targetWord + "\\b";
        Pattern secondPattern = Pattern.compile(targetWordRegex);
        for (String sentence : listOfSentences) {
            Matcher secondMatcher = secondPattern.matcher(sentence);
            if (secondMatcher.find()) {
                System.out.println(sentence);
            }
        }

    }
}

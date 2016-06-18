package Problem3JediCodeX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 16.6.2016 г..
 */
public class JediCodeX {

    public static void main(String[] args) throws IOException {

        ArrayList<String> lineArray = new ArrayList<>();
        LinkedHashMap<String, String> jediAndTheirMessages = new LinkedHashMap<>();
        ArrayList<String> messages = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            lineArray.add(reader.readLine());
        }
        String namePattern = reader.readLine();
        String fixedNamePattern = String.format("(?:(?<!%s)|^)%s([a-z-A-Z]{%d})(?![a-zA-Z])", namePattern, namePattern, namePattern.length());
        Pattern workingNamePattern = Pattern.compile(fixedNamePattern);

        String messagePattern = reader.readLine();
        String fixedMessagePattern = String.format("(?:(?<!%s)|^)%s([a-zA-Z0-9]{%d})(?![a-zA-Z0-9])", messagePattern, messagePattern, messagePattern.length());
        Pattern workingMessagePattern = Pattern.compile(fixedMessagePattern);

        for (int i = 0; i < n; i++) {
            String line = lineArray.get(i);
            Matcher nameMatcher = workingNamePattern.matcher(line);
            while (nameMatcher.find()) {
                jediAndTheirMessages.put(nameMatcher.group(1), "");
            }
            Matcher messageMatcher = workingMessagePattern.matcher(line);
            while (messageMatcher.find()) {
                messages.add(messageMatcher.group(1));
            }
        }

        int counter = 0;
        String[] messagesArray = new String[messages.size()];
        for (String message : messages) {
            messagesArray[counter++] = message;
        }

        String[] indexes = reader.readLine().split(" ");
        for (String index : indexes) {
            queue.add(Integer.parseInt(index));
        }
        for (String jedi : jediAndTheirMessages.keySet()) {
            Integer index = queue.poll();
            if (index == null) {
                PrintResults(jediAndTheirMessages);
                return;
            }
            while (index - 1 >= messagesArray.length) {
                index = queue.poll();
                if (index == null) {
                    PrintResults(jediAndTheirMessages);
                    return;
                }
            }
            String message = messages.get(index - 1);
            jediAndTheirMessages.put(jedi, message);
        }
        PrintResults(jediAndTheirMessages);
    }

    private static void PrintResults(LinkedHashMap<String, String> jediAndTheirMessages) {
        for (String jedi : jediAndTheirMessages.keySet()) {
            if (!jediAndTheirMessages.get(jedi).equals("")) {
                System.out.println(String.format("%s - %s", jedi, jediAndTheirMessages.get(jedi)));
            } else {
                break;
            }
        }
    }
}

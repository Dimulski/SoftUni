package Problem7ValidUsernames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 15.6.2016 г..
 */
public class ValidUsernames {

    private static ArrayList<String> userNames = new ArrayList<>();
    private static LinkedHashMap<Integer, String[]> lengthOfTwoUserNames = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String[] inputParams = input.split("[\\/(\\\\) ]");
        for (String username : inputParams) {
            addIfValid(username);
        }
        Integer longestCombinedLength = 0;
        for (int i = 1; i < userNames.size(); i++) {
            String secondUserName = userNames.get(i);
            String firstUserName = userNames.get(i - 1);
            Integer firstLength = firstUserName.length();
            Integer secondLength = secondUserName.length();
            if (!lengthOfTwoUserNames.containsKey(firstLength + secondLength)) {
                lengthOfTwoUserNames.put(firstLength + secondLength, new String[]{firstUserName, secondUserName});
            }
            if (longestCombinedLength < firstLength + secondLength) {
                longestCombinedLength = firstLength + secondLength;
            }
        }
        String[] resultArray = lengthOfTwoUserNames.get(longestCombinedLength);
        System.out.println(resultArray[0]);
        System.out.println(resultArray[1]);
    }

    private static void addIfValid(String username) {
        String properUserName = username.trim();
        Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9_]{2,24}$");
        Matcher matcher = pattern.matcher(properUserName);
        if (matcher.find()) {
            userNames.add(properUserName);
        }
    }
}

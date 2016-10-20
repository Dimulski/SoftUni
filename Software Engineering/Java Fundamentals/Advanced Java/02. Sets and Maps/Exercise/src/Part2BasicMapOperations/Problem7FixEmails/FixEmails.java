package Part2BasicMapOperations.Problem7FixEmails;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by User on 5.6.2016 г..
 */
public class FixEmails {

    public static void main(String[] args) {

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String oddLine = scanner.nextLine();
            if (oddLine.equals("stop")) {
                break;
            }
            String evenLine = scanner.nextLine();
            boolean endsProperly = !evenLine.endsWith("us") && !evenLine.endsWith("uk");
            if (endsProperly) {
                map.put(oddLine, evenLine);
            }
        }

        for (Map.Entry entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}

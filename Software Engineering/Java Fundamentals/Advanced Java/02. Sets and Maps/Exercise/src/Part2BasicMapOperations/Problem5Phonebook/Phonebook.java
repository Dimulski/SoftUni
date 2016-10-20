package Part2BasicMapOperations.Problem5Phonebook;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by User on 5.6.2016 г..
 */
public class Phonebook {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("search")) {
            String[] entry = line.split("-");
            map.put(entry[0],entry[1]);

            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!line.equals("stop")) {
            String number = map.get(line);
            if (number == null) {
                System.out.printf("Contact %s does not exist.%s", line, System.lineSeparator());
            } else {
                System.out.printf("%s -> %s%s", line, number, System.lineSeparator());
            }

            line = scanner.nextLine();
        }
    }
}

package Problem11PredicateParty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by User on 18.6.2016 г..
 */
public class PredicateParty {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.asList(reader.readLine().split("\\s+"));

        String input;
        while(!(input = reader.readLine()).equals("Party!")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            String modifier = tokens[1];
            String variable = tokens[2];

            Predicate<String> tester = createPredicate(modifier, variable);

            if (command.equals("Remove")) {
                names = executeRemoveCommand(names, tester);
            } else if (command.equals("Double")) {
                names = executeDoubleCommand(names, tester);
            }
        }

        if (names.size() == 0) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.join(", ", names) + " are going to the party!");
        }

    }

    private static List<String> executeRemoveCommand(List<String> names, Predicate<String> tester) {
        List <String> result = new ArrayList<>();

        for (String name : names) {
            if (!tester.test(name)) {
                result.add(name);
            }
        }

        return result;
    }

    private static Predicate<String> createPredicate(String modifier, String variable) {

        switch (modifier) {
            case "StartsWith":
                return string -> string.startsWith(variable);
            case "EndsWith":
                return string -> string.endsWith(variable);
            case "Length":
                return string -> string.length() == Integer.valueOf(variable);
            default:
                return null;
        }
    }

    private static List<String> executeDoubleCommand(List<String> names, Predicate<String> tester) {
        List<String> result = new ArrayList<>();

        for (String name : names) {
            if (tester.test(name)) {
                result.add(name);
            }

            result.add(name);
        }

        return result;
    }
}

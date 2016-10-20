package problem1ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListyIterator iterator = null;
        String[] commandParams;
        while (!((commandParams = reader.readLine().split("\\s+"))[0].equals("END") && commandParams.length == 1)) {
            try {
                switch (commandParams[0]) {
                    case "Create":
                        List<String> list = Arrays.asList(commandParams).stream().skip(1).collect(Collectors.toList());
                        iterator = new ListyIteratorImpl<String>(list);
                        break;

                    case "Print":
                        iterator.print();
                        break;

                    case "HasNext":
                        System.out.println(iterator.hasNext());
                        break;

                    case "Move":
                        System.out.println(iterator.move());
                        break;
                }
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

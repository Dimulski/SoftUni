package problem2Collection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ListyCollection collection = null;
        String[] commandParams;
        while (!((commandParams = reader.readLine().split("\\s+"))[0].equals("END") && commandParams.length == 1)) {
            try {
                switch (commandParams[0]) {
                    case "Create":
                        List<String> list = Arrays.asList(commandParams).stream().skip(1).collect(Collectors.toList());
                        collection = new ListyCollectionImpl<String>(list);
                        break;
                    case "Print":
                        collection.print();
                        break;
                    case "HasNext":
                        System.out.println(collection.hasNext());
                        break;
                    case "Move":
                        System.out.println(collection.move());
                        break;
                    case "PrintAll":
                        collection.forEach(e -> System.out.printf("%s ", e));
                        System.out.println();
                        break;
                }
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

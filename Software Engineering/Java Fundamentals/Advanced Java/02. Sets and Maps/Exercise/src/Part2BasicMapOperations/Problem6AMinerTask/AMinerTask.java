package Part2BasicMapOperations.Problem6AMinerTask;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by User on 5.6.2016 г..
 */
public class AMinerTask {

    public static void main(String[] args) {

        LinkedHashMap<String, Long> map = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String oddLine;
        String evenLine;
        Long quantity;
        while (true){
            oddLine = scanner.nextLine();
            if (oddLine.equals("stop")){
                break;
            }
            evenLine = scanner.nextLine();
            quantity = Long.parseLong(evenLine);
            if (!map.containsKey(oddLine)) {
                map.put(oddLine, Long.parseLong(evenLine));
            } else {
                map.put(oddLine, map.get(oddLine) + quantity);
            }
        }

        for (HashMap.Entry entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}

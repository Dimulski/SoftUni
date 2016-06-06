package Part2BasicMapOperations.Problem4CountSymbols;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by User on 5.6.2016 г..
 */
public class CountSymbols {

    public static void main(String[] args) {

        TreeMap<Character, Integer> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c,map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (char c : map.keySet()) {
            System.out.printf("%s: %s time/s%s",c,map.get(c), System.lineSeparator());
        }
    }
}

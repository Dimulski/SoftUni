package Part1BasicSetOperations.Problem3PeriodicTable;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by User on 4.6.2016 г..
 */
public class PeriodicTable {

    public static void main(String[] args) {

        TreeSet<String> elementSet = new TreeSet<>();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String[] elements = scanner.nextLine().split(" ");
            for (int j = 0; j < elements.length; j++) {
                elementSet.add(elements[j]);
            }
        }
        for (String element : elementSet ) {
            System.out.print(element + " ");
        }
    }
}

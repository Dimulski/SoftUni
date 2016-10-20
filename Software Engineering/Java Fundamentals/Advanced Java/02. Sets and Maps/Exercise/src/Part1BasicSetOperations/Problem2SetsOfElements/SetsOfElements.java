package Part1BasicSetOperations.Problem2SetsOfElements;

import java.util.Scanner;
import java.util.HashSet;

/**
 * Created by User on 4.6.2016 г..
 */
public class SetsOfElements {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> firstSet = new HashSet<>();
        HashSet<Integer> secondSet = new HashSet<>();

        int firstSetCount = scanner.nextInt();
        int secondSetCount = scanner.nextInt();
        for (int i = 0; i < firstSetCount; i++) {
            firstSet.add(scanner.nextInt());
        }
        for (int i = 0; i < secondSetCount; i++) {
            secondSet.add(scanner.nextInt());
        }
        firstSet.retainAll(secondSet);
        for (Integer num : firstSet ) {
            System.out.print(num + " ");
        }
    }
}

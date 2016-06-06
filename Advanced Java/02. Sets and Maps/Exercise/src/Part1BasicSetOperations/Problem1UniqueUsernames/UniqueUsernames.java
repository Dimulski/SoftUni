package Part1BasicSetOperations.Problem1UniqueUsernames;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by User on 4.6.2016 г..
 */
public class UniqueUsernames {

    public static void main(String[] args) {

        LinkedHashSet<String> set = new LinkedHashSet<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            set.add(username);
        }

        for (String username : set) {
            System.out.println(username);
        }
    }
}

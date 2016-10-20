package Part2BasicQueueOperations.Problem4BasicQueueOperations;

import java.util.*;

/**
 * Created by User on 23.5.2016 г..
 */
public class BasicQueueOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            queue.remove();
        }

        boolean bool = queue.contains(x);
        if (bool) {
            System.out.println("true");
        }
        else {
            if (n - s == 0){
                System.out.println(0);
            }
            else {
                final Comparator<Integer> comp = (a, b) -> Integer.compare(a, b);
                int smallest = queue.stream().min(comp).get();
                System.out.println(smallest);
            }
        }
    }
}

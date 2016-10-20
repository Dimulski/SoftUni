package Part3ExercisesWithStacksAndQueues.Problem8RecursiveFibonacci;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by User on 3.6.2016 г..
 */
public class MemorizedRecursiveFibonacci {

    private static HashMap<Long, Long> map = new HashMap<>();

    public static void main(String[] args) {

        long zero = 0;
        long one = 1;
        map.put(zero, one);
        map.put(one, one);

        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        System.out.println(getFib(num));
    }

    private static long getFib(long num) {
        if (map.containsKey(num)) {
            return map.get(num);
        } else {
            long value = getFib(num - 1) + getFib(num - 2);
            map.put(num, value);
            return value;
        }
    }
}

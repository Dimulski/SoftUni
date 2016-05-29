package Part2BasicQueueOperations.Problem5CalculateSequenceWithQueue;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by User on 23.5.2016 г..
 */
public class CalculateSequenceWithQueue {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BigInteger n = BigInteger.valueOf(scanner.nextLong());

        Queue<BigInteger> queue = new ArrayDeque<>(60);
        queue.add(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            BigInteger target = queue.remove();
            sb.append(target + " ");
            queue.add(target.add(BigInteger.ONE));
            queue.add(target.add(target).add(BigInteger.ONE));
            queue.add(target.add(BigInteger.valueOf(2)));
        }
        System.out.println(sb.toString());
    }
}

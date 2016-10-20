package Part3ExercisesWithStacksAndQueues.Problem9StackFibonacci;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by User on 3.6.2016 г..
 */
public class StackFibonacci {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num < 2){
            System.out.println(1);
            return;
        }
        LinkedList<Long> stack = new LinkedList<>();
        stack.push(1L);
        stack.push(1L);
        int counter = 1;
        while (counter < num){
            long second = stack.poll();
            long first = stack.poll();
            stack.push(second);
            stack.push(second + first);
            counter++;
        }
        System.out.println(stack.peek());
    }
}

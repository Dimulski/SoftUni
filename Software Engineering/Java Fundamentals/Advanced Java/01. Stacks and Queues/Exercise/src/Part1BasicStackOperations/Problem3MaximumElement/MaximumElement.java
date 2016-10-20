package Part1BasicStackOperations.Problem3MaximumElement;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by User on 19.5.2016 г..
 */
public class MaximumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1: {
                    int num = scanner.nextInt();
                    stack.push(num);
                    if (max <= num) {
                        max = num;
                        maxStack.push(max);
                    }
                    break;
                }
                case 2: {
                    int num = stack.pop();
                    if (num == max) {
                        maxStack.pop();
                        if (maxStack.size() > 0) {
                            max = maxStack.peek();
                        } else {
                            max = Integer.MIN_VALUE;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println(max);
                }
            }
        }
    }
}
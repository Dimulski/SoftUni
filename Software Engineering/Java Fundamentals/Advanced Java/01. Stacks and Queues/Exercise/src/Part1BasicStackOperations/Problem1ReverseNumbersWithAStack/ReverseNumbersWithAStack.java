package Part1BasicStackOperations.Problem1ReverseNumbersWithAStack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by User on 19.5.2016 г..
 */
public class ReverseNumbersWithAStack {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            stack.push(Integer.parseInt(input[i]));
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop() + " ");
        }
    }
}

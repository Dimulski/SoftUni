package Part3ExercisesWithStacksAndQueues.Problem7BalancedParentheses;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by User on 4.6.2016 г..
 */
public class SmartestBalancedParentheses {

    public static void main(String[] args) {

        boolean isBalanced = true;
        Scanner scanner = new Scanner(System.in);
        String brackets = scanner.nextLine();
        LinkedList<Character> stack = new LinkedList<>();

        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);
            if (bracket == '(' || bracket == '{' || bracket == '[') {
                stack.push(bracket);
            } else {
                if (bracket == ')') {
                    bracket = '(';
                } else if (bracket == '}') {
                    bracket = '{';
                } else {
                    bracket = '[';
                }

                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                if (bracket == stack.peek()) {
                    stack.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }
        }
        System.out.println(isBalanced? "YES" : "NO");
    }
}

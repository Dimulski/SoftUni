package Part3ExercisesWithStacksAndQueues.Problem7BalancedParentheses;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by User on 24.5.2016 г..
 */
public class BalancedParentheses {

    static String input;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        boolean bool = ValidateSequence(0, input.length());
        PrintOutput(bool);
    }

    private static boolean ValidateSequence(int start, int end) {

        Stack<Integer> normalBrackets = new Stack<>();
        Stack<Integer> curlyBrackets = new Stack<>();
        Stack<Integer> squareBrackets = new Stack<>();
        int i2 = 0;

        for (int i = start; i < end; i++) {
            i2 = i;
            if (input.charAt(i) == 'x') {
            } else {
                if (input.charAt(i) == '(') {
                    normalBrackets.add(i);
                }
                else if (input.charAt(i) == '{') {
                    curlyBrackets.add(i);
                }
                else if (input.charAt(i) == '[') {
                    squareBrackets.add(i);
                }
                else if (input.charAt(i) == ')') {
                    if (normalBrackets.empty() || (normalBrackets.peek() - i - 1) % 2 != 0) {
                        return false;
                    } else {
                        ValidateSequence(normalBrackets.pop() + 1, i - 1);
                    }
                }
                else if (input.charAt(i) == '}') {
                    if (curlyBrackets.empty() || (curlyBrackets.peek() - i - 1) % 2 != 0) {
                        return false;
                    } else {
                        ValidateSequence(curlyBrackets.pop() + 1, i - 1);
                    }
                }
                else if (input.charAt(i) == ']') {
                    if (squareBrackets.empty() || (squareBrackets.peek() - i - 1) % 2 != 0) {
                        return false;
                    } else {
                        ValidateSequence(squareBrackets.pop() + 1, i - 1);
                    }
                }
            }
        }

        if (!normalBrackets.empty() || !curlyBrackets.empty() || !squareBrackets.empty()) {
            return false;
        } else {
            if (i2 < input.length() - 1){
                int lengthOfCheckedString = 0;
                for (int i = start - 1; i <= end + 1; i++) {
                    lengthOfCheckedString++;
                }
                StringBuilder fillerString = new StringBuilder();

                for (int j = 0; j < lengthOfCheckedString; j++) {
                    fillerString.append("x");
                }
                input = input.substring(0,start - 1) + fillerString.toString() + input.substring(end + 2);
            }

        }
        return true;
    }

    private static void PrintOutput(boolean bool) {
        if (bool) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

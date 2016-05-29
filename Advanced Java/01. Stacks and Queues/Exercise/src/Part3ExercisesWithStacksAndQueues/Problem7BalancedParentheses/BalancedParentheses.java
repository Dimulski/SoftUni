package Part3ExercisesWithStacksAndQueues.Problem7BalancedParentheses;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by User on 24.5.2016 г..
 */
public class BalancedParentheses {

    static String input;
    static Stack<Integer> normalBrackets;
    static Stack<Integer> curlyBrackets;
    static Stack<Integer> squareBrackets;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();

        normalBrackets = new Stack<>();
        curlyBrackets = new Stack<>();
        squareBrackets = new Stack<>();

        boolean bool = ValidateSequence(0, input.length());
        PrintOutputAndExit(bool);
    }

    private static boolean ValidateSequence(int start, int end) {

        int length = Math.abs(start - end);

        for (int i = start; i < end; i++) {
            if (input.charAt(i) == '(') {
                normalBrackets.add(i);
            }
            if (input.charAt(i) == '{') {
                curlyBrackets.add(i);
            }
            if (input.charAt(i) == '[') {
                squareBrackets.add(i);
            }
            if (input.charAt(i) == ')') {
                if (normalBrackets.empty() || Math.abs(normalBrackets.peek() - i) % 2 != 0) {
                    PrintOutputAndExit(false);
                } else {
                    boolean bool = ValidateSequence(normalBrackets.peek() + 1, i);
                    if (bool) {
                        input = input.substring(0,start) + input.substring(end, input.length());
                    }
                }
            }
        }

    }

    private static void PrintOutputAndExit(boolean bool) {
        if (bool) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        System.exit(0);
    }
}

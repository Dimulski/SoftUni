package Part3ExercisesWithStacksAndQueues.Problem7BalancedParentheses;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by User on 3.6.2016 г..
 * By courtesy of Simona Mitrenova
 */
public class SmartBalancedParentheses {

    public static void main(String[] args) {

        HashMap<Character, Character> parenthesis = new HashMap<>();
        parenthesis.put(']', '[');
        parenthesis.put(')', '(');
        parenthesis.put('}', '{');
        LinkedList<Character> stack = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            Character current = input.charAt(i);
            if (!parenthesis.containsKey(current)){
                stack.push(current);
            } else if (stack.size() == 0){
                System.out.println("NO");
                return;
            } else if (parenthesis.get(current) == stack.peek()){
                stack.poll();
            } else if (parenthesis.get(current) != stack.peek()){
                System.out.println("NO");
                return;
            }
        }

        if (stack.size() != 0){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}

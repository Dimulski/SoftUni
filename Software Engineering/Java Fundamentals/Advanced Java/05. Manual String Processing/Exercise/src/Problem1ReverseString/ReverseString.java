package Problem1ReverseString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by User on 9.6.2016 г..
 */
public class ReverseString {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("");
        Stack<String> stack = new Stack<>();
        for (String letter : input) {
            stack.push(letter);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}

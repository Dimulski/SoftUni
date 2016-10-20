package Part1BasicStackOperations.Problem2BasicStackOperations;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by User on 19.5.2016 г..
 */
public class BasicStackOperations {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String[] firstLine = scanner.nextLine().trim().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int s = Integer.parseInt(firstLine[1]);
        int x = Integer.parseInt(firstLine[2]);
        int d = n - s;
        Stack<Integer> stack = new Stack<>();

        int currentMin = Integer.MAX_VALUE;
        for (int i = 0, j = d; i < n; i++, j--) {
            int current = scanner.nextInt();
            stack.push(current);
            if (j > 0){
                if (current <= currentMin){
                    currentMin = current;
                }
            }
        }
        for (int i = 0; i < s; i++) {
            stack.pop();
        }
        if (stack.contains(x)) {
            System.out.println("true");
        }
        else {
            if (d <= 0){
                System.out.println(0);
            }
            else {
                System.out.println(currentMin);
            }
        }
    }
}

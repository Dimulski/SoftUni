package Part3ExercisesWithStacksAndQueues.Problem10SimpleTextEditor;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by User on 3.6.2016 г..
 */
public class SimpleTextEditor {

    public static void main(String[] args) {
        
        StringBuilder sb = new StringBuilder();
        LinkedList<String> undoStack = new LinkedList<>();
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int command = scanner.nextInt();
            switch (command) {
                case 1: {
                    String stringToAppend = scanner.next();
                    sb.append(stringToAppend);
                    undoStack.push(sb.toString()); // Adding the state of the text after this command instead of individual changes. Greedy.
                    break;
                }
                case 2: {
                    int deleteCount = scanner.nextInt();
                    sb.delete(sb.length() - deleteCount, sb.length());
                    undoStack.push(sb.toString());
                    break;
                }
                case 3: {
                    int index = scanner.nextInt();
                    System.out.println(sb.charAt(index - 1));
                    break;
                }
                case 4: {
                    undoStack.pop();
                    if (undoStack.size() > 0) {
                        sb = new StringBuilder(undoStack.peek());
                    } else {
                        sb = new StringBuilder();
                    }
                    break;
                }
            }
        }
    }
}

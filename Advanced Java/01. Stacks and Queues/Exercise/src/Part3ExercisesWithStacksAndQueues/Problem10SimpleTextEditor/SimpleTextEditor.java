package Part3ExercisesWithStacksAndQueues.Problem10SimpleTextEditor;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by User on 3.6.2016 г..
 */
public class SimpleTextEditor {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numOfCommands = scanner.nextInt();
        scanner.nextLine();

        LinkedList<String[]> commandStack = new LinkedList<>();
        LinkedList<Character> charStack = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numOfCommands; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "1": {
                    commandStack.push(command);
                    sb.append(command[1]);
                    break;
                }
                case "2": {
                    commandStack.push(command);
                    charStack.push(sb.charAt(Integer.parseInt(command[1]) - 1));
                    sb.deleteCharAt(Integer.parseInt(command[1]) - 1);
                    break;
                }
                case "3": {
                    System.out.println(sb.charAt(Integer.parseInt(command[1]) - 1));
                    break;
                }
                case "4": {
                    String[] commandToUndo = commandStack.pop();
                    switch (commandToUndo[0]) {
                        case "1": {
                            int stringLength = commandToUndo[1].length();
                            sb.delete(sb.length() - stringLength, stringLength);
                            break;
                        }
                        case "2": {
                            Character charToReturn = charStack.pop();
                            sb.insert(Integer.parseInt(commandToUndo[1]), charToReturn);
                            break;
                        }
                    }
                }
            }
        }
    }
}

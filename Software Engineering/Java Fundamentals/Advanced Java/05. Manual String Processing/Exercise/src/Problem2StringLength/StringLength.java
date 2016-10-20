package Problem2StringLength;

import java.util.Scanner;

/**
 * Created by User on 9.6.2016 г..
 */
public class StringLength {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder(scanner.nextLine());
        if (input.length() >= 20){
            System.out.println(input.replace(20, input.length(), ""));
        } else {
            for (int i = input.length(); i < 20; i++) {
                input.append('*');
            }
            System.out.println(input);
        }
    }
}

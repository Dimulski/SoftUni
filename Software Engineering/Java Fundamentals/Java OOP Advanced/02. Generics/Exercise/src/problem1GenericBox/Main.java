package problem1GenericBox;

import problem1GenericBox.models.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            Box<String> box = new Box<String>();
            box.storeItem(reader.readLine());
            System.out.println(box.toString());
        }
    }
}

package problem3GenericSwapMethodStrings;

import problem3GenericSwapMethodStrings.models.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Box<String> box = new Box<String>();
            box.storeItem(reader.readLine());
            boxes.add(box);
        }
        String[] indexes = reader.readLine().split(" ");
        GenericMethods.swapElements(boxes, Integer.parseInt(indexes[0]), Integer.parseInt(indexes[1]));
        boxes.stream().forEach(box -> System.out.println(box.toString()));
    }
}

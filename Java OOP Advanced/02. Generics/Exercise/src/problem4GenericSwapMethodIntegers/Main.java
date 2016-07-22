package problem4GenericSwapMethodIntegers;

import problem4GenericSwapMethodIntegers.models.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(reader.readLine());
        List<Box> boxes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Box<Integer> box = new Box<Integer>();
            box.storeItem(Integer.parseInt(reader.readLine()));
            boxes.add(box);
        }
        int[] indexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        GenericMethods.swapElements(boxes, indexes[0], indexes[1]);
        boxes.stream().forEach(box -> System.out.println(box.toString()));
    }
}

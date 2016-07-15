package d3.genericMethods;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {

    public static <T> List<T> createList(T item, int count) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(item);
        }

        return list;
    }

    public static <T> void printClass(T item) {
        System.out.println(item.getClass().getName());
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }

        return max;
    }
}

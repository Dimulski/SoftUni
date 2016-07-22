package problem6GenericCountMethodDoubles;

import java.util.List;

public abstract class GenericMethods {

    public static <T extends Comparable<T>> int CountGreaterThan(List<T> elements, T targetElement) {
        int count = 0;
        for (T element : elements) {
            if (element.compareTo(targetElement) > 0) {
                count++;
            }
        }
        return count;
    }
}

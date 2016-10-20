package problem5GenericCountMethodStrings;

import java.util.List;

abstract class GenericMethods {

    static <T extends Comparable<T>> int CountGreaterThat(List<T> elements, T targetElement) {
        int count = 0;
        for (T element : elements) {
            if (element.compareTo(targetElement) > 0) {
                count++;
            }
        }
        return count;
    }
}

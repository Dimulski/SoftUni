package problem3GenericSwapMethodStrings;

import java.util.List;

abstract class GenericMethods {

    static <T> void swapElements(List<T> elements, int firstIndex, int secondIndex) {
        T temp = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, temp);
    }
}

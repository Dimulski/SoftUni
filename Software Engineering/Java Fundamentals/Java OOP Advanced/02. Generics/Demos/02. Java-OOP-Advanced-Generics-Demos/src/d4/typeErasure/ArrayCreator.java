package d4.typeErasure;

import java.lang.reflect.Array;

public class ArrayCreator<T> {

    public static <T> T[] create(Class<T> classType, int capacity) {
        return (T[]) Array.newInstance(classType, capacity);
    }
}

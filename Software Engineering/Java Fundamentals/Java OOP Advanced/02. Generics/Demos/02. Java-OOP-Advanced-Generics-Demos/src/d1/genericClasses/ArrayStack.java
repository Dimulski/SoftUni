package d1.genericClasses;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Container<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private Class<E> classType;
    private int index = 0;
    private E[] array;

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<E> classType) {
        this.classType = classType;
        array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(Class<E> classType, int capacity) {
        this.classType = classType;
        array = (E[]) Array.newInstance(classType, capacity);
    }

    public void push(E element) {
        if (this.index == this.array.length) {
            this.resize();
        }

        this.array[this.index] = element;
        index++;
    }

    public E pop() {
        if (this.index == 0) {
            throw new EmptyStackException();
        }

        return this.array[--index];
    }

    public E peek() {
        return this.array[this.index - 1];
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        E[] newArray = (E[]) Array.newInstance(this.classType, this.array.length * 2);
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }

        this.array = newArray;
    }
}

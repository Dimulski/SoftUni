package d1.genericClasses;

public interface Container<T> {
    void push(T element);
    T pop();
}

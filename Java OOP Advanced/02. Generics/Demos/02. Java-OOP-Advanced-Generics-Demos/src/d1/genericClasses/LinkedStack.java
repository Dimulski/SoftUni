package d1.genericClasses;

public class LinkedStack<T> {

    private class Node {
        T item;
        Node next;

        Node() {
            this.item = null;
            this.next = null;
        }

        Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return this.item == null && this.next == null;
        }
    }

    private Node top = new Node();

    public void push(T item) {
        this.top = new Node(item, this.top);
    }

    public T pop() {
        T result = this.top.item;
        if (!this.top.end()) {
            this.top = this.top.next;
        }

        return result;
    }
}

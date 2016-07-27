package problem2Collection;

interface ListyCollection<T> extends Iterable<T> {

    boolean move();

    boolean hasNext();

    void print();
}

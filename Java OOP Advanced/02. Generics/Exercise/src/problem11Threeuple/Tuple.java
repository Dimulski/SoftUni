package problem11Threeuple;

class Tuple<T, S> {

    private T item1;
    private S item2;

    Tuple(T item1, S item2) {
        this.setItem1(item1);
        this.setItem2(item2);
    }

    private T getItem1() {
        return this.item1;
    }

    private S getItem2() {
        return this.item2;
    }

    private void setItem1(T item1) {
        this.item1 = item1;
    }

    private void setItem2(S item2) {
        this.item2 = item2;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", getItem1().toString(), getItem2().toString());
    }
}

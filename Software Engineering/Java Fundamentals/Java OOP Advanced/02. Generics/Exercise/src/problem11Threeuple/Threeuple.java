package problem11Threeuple;

class Threeuple<T, S, U> extends Tuple {
    private U item3;

    @SuppressWarnings("unchecked")
    Threeuple(T item1, S item2, U item3) {
        super(item1, item2);
        this.setItem3(item3);
    }

    private U getItem3() {
        return this.item3;
    }

    private void setItem3(U item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" -> %s", getItem3().toString());
    }
}

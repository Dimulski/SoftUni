package problem1GenericBox.models;

public class Box<T> {

    private T storedItem;

    public Box() {
        this.setStoredItem(null);
    }

    public void storeItem(T item) {
        this.setStoredItem(item);
    }

    public T getStoredItem() {
        return this.storedItem;
    }

    private void setStoredItem(T storedItem) {
        this.storedItem = storedItem;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", getStoredItem().getClass().getName(), getStoredItem());
    }
}

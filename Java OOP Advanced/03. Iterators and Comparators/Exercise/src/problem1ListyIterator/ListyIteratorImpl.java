package problem1ListyIterator;

import java.util.List;

class ListyIteratorImpl<T> implements ListyIterator {

    private static final int STARTING_INDEX = 0;
    private List<T> list;
    private int index;

    ListyIteratorImpl(List<T> list) { // something something varArgs...
        this.setList(list);
        this.setIndex(STARTING_INDEX);
    }

    private int getIndex() {
        return this.index;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    private List<T> getList() {
        return this.list;
    }

    private void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean move() {
        if (hasNext()) {
            setIndex(getIndex() + 1);
            return true;
        }

        return false;
    }

    @Override
    public boolean hasNext() {
        return getIndex() < getList().size() - 1;
    }

    @Override
    public void print() {
        if (this.getList().isEmpty()){
            throw new IllegalStateException("Invalid Operation!");
        }

        System.out.println(this.getList().get(this.index));
    }
}

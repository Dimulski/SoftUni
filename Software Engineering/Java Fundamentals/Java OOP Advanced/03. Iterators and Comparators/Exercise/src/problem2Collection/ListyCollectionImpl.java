package problem2Collection;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

class ListyCollectionImpl<T> implements ListyCollection {

    private static final int STARTING_INDEX = 0;
    private List<T> list;
    private int index;

    ListyCollectionImpl(List<T> list) {
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

    @Override
    public Iterator iterator() {
        return new ListyIterator();
    }

    @Override
    public void forEach(Consumer action) {
        for(Iterator<T> i = this.iterator(); i.hasNext(); ) {
            T item = i.next();
            action.accept(item);
        }
    }

    private class ListyIterator implements Iterator<T> {

        private final int START_INDEX = 0;
        private int index;

        private ListyIterator() {
            this.setIndex(START_INDEX);
        }

        private int getIndex() {
            return this.index;
        }

        private void setIndex(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return this.getIndex() < getList().size();
        }

        @Override
        public T next() {
            if (this.hasNext()) {
                int index = this.getIndex();
                this.setIndex(this.getIndex() + 1);
                return getList().get(index);
            }

            throw new NoSuchElementException();
        }
    }
}

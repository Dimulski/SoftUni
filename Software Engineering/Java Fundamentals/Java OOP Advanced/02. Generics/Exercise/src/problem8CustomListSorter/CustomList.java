package problem8CustomListSorter;

import java.util.ArrayList;
import java.util.List;

class CustomList<T extends Comparable<T>> {

    private static final String EMPTY_LIST_EXCEPTION_MESSAGE = "List is empty!";
    private List<T> list;

    CustomList() {
        this.setList(new ArrayList<T>());
    }

    List<T> getList() {
        return this.list;
    }

    private void setList(List<T> list) {
        this.list = list;
    }

    void add(T element) {
        getList().add(element);
    }

    T remove(int index) {
        return getList().remove(index);
    }

    boolean contains(T element) {
        return getList().contains(element);
    }

    void swap(int firstIndex, int secondIndex) {
        T temp = getList().get(firstIndex);
        getList().set(firstIndex, getList().get(secondIndex));
        getList().set(secondIndex, temp);
    }

    int countGreaterThan(T targetElement) {
        int count = 0;
        for (T element : getList()) {
            if (element.compareTo(targetElement) > 0) {
                count++;
            }
        }
        return count;
    }

    T getMax() {
        if (getList().isEmpty()) {
            throw new IllegalStateException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }

        T max = getList().get(0);
        for (int i = 1; i < getList().size(); i++) {
            if (getList().get(i).compareTo(max) > 0) {
                max = getList().get(i);
            }
        }
        return max;
    }

    T getMin() {
        if (getList().isEmpty()) {
            throw new IllegalStateException(EMPTY_LIST_EXCEPTION_MESSAGE);
        }

        T min = getList().get(0);
        for (int i = 1; i < getList().size(); i++) {
            if (getList().get(i).compareTo(min) < 0) {
                min = getList().get(i);
            }
        }
        return min;
    }
}

package problem9CustomListIterator;

class Sorter {

    <T extends Comparable<T>> void sort(CustomList<T> customList) {
        customList.getList().sort(Comparable::compareTo);
    }
}

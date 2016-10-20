package problem8CustomListSorter;

class Sorter {

    <T extends Comparable<T>> void sort(CustomList<T> customList) {
        customList.getList().sort((e1, e2) -> e1.compareTo(e2));
    }
}

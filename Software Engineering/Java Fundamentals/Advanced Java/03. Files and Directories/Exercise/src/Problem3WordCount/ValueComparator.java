package Problem3WordCount;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by User on 9.6.2016 г..
 * Doesn't count entries with the same values. Example: when asked to putAll:
 * "he" - 12
 * "she" - 9
 * "said" - 5
 * "her" - 5
 * "his" - 5
 * "with" - 3
 * It will only put "his" - 5. "her" and "said" will not be entered.
 */
class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

    HashMap<K, V> map = new HashMap<K, V>();

    public ValueComparator(HashMap<K, V> map) {
        this.map.putAll(map);
    }

    @Override
    public int compare(K s1, K s2) {
        return -map.get(s1).compareTo(map.get(s2)); // descending order
    }
}
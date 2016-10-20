package test.bg.softuni.dataStructures;

import main.bg.softuni.contracts.SimpleOrderedBag;
import main.bg.softuni.dataStructures.SimpleSortedList;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleSortedListTest {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp(){
        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyConstructor(){
        int expectedCapacity = 16;
        int expectedSize = 0;

        this.names = new SimpleSortedList<>(String.class);

        assertEquals(expectedCapacity, this.names.capacity());
        assertEquals(expectedSize, this.names.size());
    }

    @Test
    public void testConstructorWithInitialCapacity(){
        int expectedCapacity = 20;
        int expectedSize = 0;

        this.names = new SimpleSortedList<>(String.class, expectedCapacity);
        assertEquals(expectedCapacity, this.names.capacity());
        assertEquals(expectedSize, this.names.size());
    }

    @Test
    public void testConstructorWithInitialComparator(){
        int expectedCapacity = 16;
        int expectedSize = 0;

        this.names = new SimpleSortedList<>(String.class, Comparator.naturalOrder());

        assertEquals(expectedCapacity, this.names.capacity());
        assertEquals(expectedSize, this.names.size());
    }

    @Test
    public void testConstructorWithInitialComparatorAndInitialCapacity(){
        int expectedCapacity = 30;
        int expectedSize = 0;

        this.names = new SimpleSortedList<>(String.class, Comparator.reverseOrder(), 30);
        assertEquals(expectedCapacity, this.names.capacity());
        assertEquals(expectedSize, this.names.size());
    }

    @Test
    public void testAddShouldIncreaseSize(){
        int expectedSize = 1;
        this.names.add("Pesho");
        assertEquals(expectedSize, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNullShouldThrow(){
        this.names.add(null);
    }

    @Test
    public void testAddAllUnsortedDataShouldSortIt(){
        String[] expected = {"Balkan", "Georgi", "Rosen"};
        this.names.addAll(Arrays.asList("Rosen", "Georgi", "Balkan"));
        int index = 0;
        for (String name : names) {
            assertEquals(expected[index++], name);
        }
    }

    @Test
    public void testAddingMoreThanInitialCapacityShouldDoubleTheCapacity(){
        int expectedSize = 17;
        int expectedCapacity = 32;
        for (int i = 0; i < expectedSize; i++) {
            this.names.add(String.format("%d", i));
        }

        assertEquals(expectedSize, this.names.size());
        assertEquals(expectedCapacity, this.names.capacity());
    }

    @Test
    public void testAddingAllFromCollectionIncreasesSize(){
        int expectedSize = 2;
        this.names.addAll(Arrays.asList("one", "two"));
        assertEquals(expectedSize, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAllWithNullShouldThrow(){
        this.names.addAll(null);
    }

    @Test
    public void testAddAllKeepsSorted(){
        List<String> elements = Arrays.asList("Z", "S", "A", "C", "K");
        this.names.addAll(elements);
        Collections.sort(elements);
        int index = 0;
        for (String name : names) {
            assertEquals(elements.get(index++), name);
        }
    }

    @Test
    public void testRemoveValidElementShouldDecreasesSize(){
        this.names.addAll(Arrays.asList("one", "two"));
        this.names.remove("one");

        int expectedSize = 1;
        assertEquals(expectedSize, this.names.size());
    }

    @Test
    public void testRemoveValidElementRemovesSelectedOne(){
        this.names.addAll(Arrays.asList("one", "two"));
        this.names.remove("one");
        for (String name : names) {
            assertEquals("two", name);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemovingNullThrowsException(){
        this.names.addAll(Arrays.asList("one", "two"));
        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testJoinWithNullShouldThrow(){
        this.names.addAll(Arrays.asList("one", "two"));
        this.names.joinWith(null);
    }

    @Test
    public void testJoinWorksFine(){
        String expectedResult = "1, 2, 3";
        this.names.addAll(Arrays.asList("1", "2", "3"));
        String actualResult = this.names.joinWith(", ");
        assertEquals(expectedResult, actualResult);
    }
}

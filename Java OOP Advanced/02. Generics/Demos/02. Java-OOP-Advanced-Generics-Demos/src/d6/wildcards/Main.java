package d6.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Animal[] animalArray = new Animal[5];
        Cat[] catArray = new Cat[5];
        animalArray = catArray;

        List<Animal> animalList = new ArrayList<>();
        List<Cat> catList = new ArrayList<>();
        // animalList = catList; // *Does not compile

        printAnimalList(animalList);
        // printNumberList(catList); // *Does not compile

        addCatToList(catList, new Cat());
        addCatToList(catList, new Kitten());
    }
    
    public static void printAnimalList(List<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }

    public static void addCatsToList(List<? super Cat> cats) {
        cats.add(new Cat());
        cats.add(new Kitten());
        // cats.add(new Dog());
        // cats.add(new Animal());
        // cats.add(new Object());
    }

    public static <T extends Cat> void addCatToList(List<? super T> list, T item) {
        list.add(item);
    }
}

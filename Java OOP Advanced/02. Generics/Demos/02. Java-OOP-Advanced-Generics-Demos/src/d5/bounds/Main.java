package d5.bounds;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        //print(objects);

        System.out.println((Object) cats.toString());
    }

    public static <T extends Animal> T print(List<? super Animal> list) {
        return (T)list.get(0);
    }
}

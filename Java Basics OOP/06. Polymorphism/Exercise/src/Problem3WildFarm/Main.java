package Problem3WildFarm;

import Problem3WildFarm.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String even;
        while (!(even = reader.readLine()).equals("End")) {
            String[] animalParams = even.split(" ");
            String[] foodParams = reader.readLine().split(" ");
            Food food = null;
            switch (foodParams[0]) {
                case "Vegetable":
                    food = new Vegetable(Integer.parseInt(foodParams[1]));
                    break;
                case "Meat":
                    food = new Meat(Integer.parseInt(foodParams[1]));
                    break;
            }
            Animal animal = null;
            switch (animalParams[0]) {
                case "Cat":
                    animal = new Cat(animalParams[0], animalParams[1],
                            Double.parseDouble(animalParams[2]), animalParams[3], animalParams[4]);
                    break;
                case "Tiger":
                    animal = new Tiger(animalParams[0], animalParams[1],
                            Double.parseDouble(animalParams[2]), animalParams[3]);
                    break;
                case "Zebra":
                    animal = new Zebra(animalParams[0], animalParams[1],
                            Double.parseDouble(animalParams[2]), animalParams[3]);
                    break;
                case "Mouse":
                    animal = new Mouse(animalParams[0], animalParams[1],
                            Double.parseDouble(animalParams[2]), animalParams[3]);
                    break;
            }
            if (animal != null){
                animal.makeSound();
                try{
                    animal.eat(food);
                } catch (IllegalArgumentException ex){
                    System.out.println(ex.getMessage());
                }
                System.out.println(animal);
            }
        }
    }
}

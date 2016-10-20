package Problem6Animals;

import Problem6Animals.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("Beast!")) {
            try {
                String animalSpecies = line;
                String[] animalParams = reader.readLine().split("\\s+");
                String name = animalParams[0];
                Integer age = Integer.parseInt(animalParams[1]);
                String gender = animalParams[2];
                switch (animalSpecies) {
                    case "Cat":
                        Animal cat = new Cat(name, age, gender);
                        System.out.println(cat);
                        System.out.println(cat.produceSound());
                        break;
                    case "Dog":
                        Animal dog = new Dog(name, age, gender);
                        System.out.println(dog);
                        System.out.println(dog.produceSound());
                        break;
                    case "Frog":
                        Animal frog = new Frog(name, age, gender);
                        System.out.println(frog);
                        System.out.println(frog.produceSound());
                        break;
                    case "Kitten":
                        Animal kitten = new Kitten(name, age);
                        System.out.println(kitten);
                        System.out.println(kitten.produceSound());
                        break;
                    case "Tomcat":
                        Animal tomcat = new Tomcat(name, age);
                        System.out.println(tomcat);
                        System.out.println(tomcat.produceSound());
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

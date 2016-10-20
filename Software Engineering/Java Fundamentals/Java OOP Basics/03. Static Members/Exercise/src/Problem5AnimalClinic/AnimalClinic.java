package Problem5AnimalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class AnimalClinic {

    static Integer patientID = 1;
    static Integer healedAnimalsCount = 0;
    static Integer rehabilitatedAnimalsCount = 0;
    static LinkedList<Animal> healedAnimals = new LinkedList<>();
    static LinkedList<Animal> rehabilitatedAnimals = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            String[] lineParams = line.split(" ");
            String name = lineParams[0];
            String breed = lineParams[1];
            String command = lineParams[2];
            switch (command) {
                case "heal":
                    healedAnimalsCount++;
                    System.out.println(String.format("Patient %d: [%s (%s)] has been healed!", patientID++, name, breed));
                    healedAnimals.add(new Animal(name, breed));
                    break;
                case "rehabilitate":
                    rehabilitatedAnimalsCount++;
                    System.out.println(String.format("Patient %d: [%s (%s)] has been rehabilitated!", patientID++, name, breed));
                    rehabilitatedAnimals.add(new Animal(name, breed));
                    break;
            }
        }
        System.out.println(String.format("Total healed animals: " + healedAnimalsCount));
        System.out.println(String.format("Total rehabilitated animals: " + rehabilitatedAnimalsCount));

        String finalCommand = reader.readLine();
        switch (finalCommand) {
            case "rehabilitate":
                for (Animal animal : rehabilitatedAnimals) {
                    System.out.println(animal.name + " " + animal.breed);
                }
                break;
            case "heal":
                for (Animal animal : healedAnimals) {
                    System.out.println(animal.name + " " + animal.breed);
                }
                break;
        }
    }
}

class Animal {
    String name;
    String breed;

    Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }
}

package Problem12PrintPeople;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class PrintPeople {

    public static void main(String[] args) throws IOException {

        List<Person> people = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("END")) {
            String[] lineParams = line.split(" ");
            Person person = new Person(lineParams[0], Integer.parseInt(lineParams[1]), lineParams[2]);
            people.add(person);
        }
        people.stream().sorted().forEach(System.out::println);
    }
}

class Person implements Comparable<Person>{
    String name;
    Integer age;
    String occupation;

    Person(String name, Integer age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return String.format("%s - age: %d, occupation: %s", this.name, this.age, this.occupation);
    }

    @Override
    public int compareTo(Person p) {
        return Integer.compare(this.age, p.age);
    }
}

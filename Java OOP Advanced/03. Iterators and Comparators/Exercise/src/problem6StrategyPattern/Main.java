package problem6StrategyPattern;

import problem6StrategyPattern.comparators.AgeComparator;
import problem6StrategyPattern.comparators.NameComparator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<Person> peopleByName = new TreeSet<>(new NameComparator());
        TreeSet<Person> peopleByAge = new TreeSet<>(new AgeComparator());

        Integer n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] personParams = reader.readLine().split("\\s+");
            Person person = new PersonImpl(personParams[0], Integer.parseInt(personParams[1]));
            peopleByName.add(person);
            peopleByAge.add(person);
        }

        peopleByName.forEach(System.out::println);
        peopleByAge.forEach(System.out::println);
    }
}

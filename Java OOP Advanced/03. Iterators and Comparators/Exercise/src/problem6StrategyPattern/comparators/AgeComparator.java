package problem6StrategyPattern.comparators;

import problem6StrategyPattern.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return firstPerson.getAge().compareTo(secondPerson.getAge());
    }
}

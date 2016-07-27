package problem6StrategyPattern.comparators;

import problem6StrategyPattern.Person;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        Integer compareNameLength = Integer.valueOf(firstPerson.getName().length())
                .compareTo(secondPerson.getName().length());
        if (compareNameLength != 0) {
            return compareNameLength;
        } else {
            return String.valueOf(firstPerson.getName().charAt(0))
                    .compareToIgnoreCase(String.valueOf(secondPerson.getName().charAt(0)));
        }
    }
}

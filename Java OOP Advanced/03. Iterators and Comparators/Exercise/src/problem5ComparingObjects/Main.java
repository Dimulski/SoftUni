package problem5ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Person> people = new ArrayList<>();

        String[] lineParams = null;
        while (!((lineParams = reader.readLine().split("\\s+"))[0].equals("END") && lineParams.length == 1)) {
            Person person = new PersonImpl(lineParams[0], Integer.parseInt(lineParams[1]), lineParams[2]);
            people.add(person);
        }

        Integer targetPersonIndex = Integer.parseInt(reader.readLine()) - 1;
        System.out.println(getPersonStatistics(targetPersonIndex, people));
    }

    private static String getPersonStatistics(Integer personIndex, List<Person> people) {
        Person targetPerson = people.get(personIndex);

        Integer numberOfEqualPeople = 0;
        for (Person person : people) {
            if (targetPerson.compareTo(person) == 0) {
                numberOfEqualPeople++;
            }
        }
        numberOfEqualPeople--;

        // If there is only one copy of targetPerson there are no equal people,
        // but if there are two copies - there is not one person equal to targetPerson, there are two. Great job!
        if (numberOfEqualPeople != 0) {
            numberOfEqualPeople++;
        }

        Integer numberOfNotEqualPeople = people.size() - numberOfEqualPeople;

        if (numberOfEqualPeople == 0) {
            return "No matches";
        }
        return String.format("%d %d %d", numberOfEqualPeople, numberOfNotEqualPeople, people.size());
    }
}

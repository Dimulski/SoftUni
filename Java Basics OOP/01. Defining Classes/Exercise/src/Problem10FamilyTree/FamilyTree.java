package Problem10FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class FamilyTree { // #firstTry

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Person> people = new LinkedHashMap<>();

        Person targetPerson = new Person();
        boolean hasBirthday = false;

        String[] firstLine = reader.readLine().split(" ");
        if (firstLine.length == 1) {
            targetPerson.birthday = firstLine[0];
            hasBirthday = true;
        } else {
            targetPerson.firstName = firstLine[0];
            targetPerson.lastName = firstLine[1];
        }
        LinkedList<String> personInfo = new LinkedList<>();
        LinkedList<String> relation = new LinkedList<>();
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            if (line.contains(" - ")) {
                relation.add(line);
            } else {
                personInfo.add(line);
            }
        }
        for (String info : personInfo) {
            String[] infoParams = info.split(" ");
            Person person = new Person(infoParams[0], infoParams[1], infoParams[2]);
            people.put(infoParams[2], person);
        }
        Person fullPerson = null;
        if (hasBirthday) {
            fullPerson = people.get(targetPerson.birthday);
        } else {
            for (Person person : people.values()) {
                if (person.firstName.equals(targetPerson.firstName) && person.lastName.equals(targetPerson.lastName)) {
                    fullPerson = person;
                }
            }
        }
        String fullName = String.format("%s %s", fullPerson.firstName, fullPerson.lastName);
        StringBuilder result = new StringBuilder();
        result.append(String.format("%s%s", fullPerson, System.lineSeparator()));
        for (String relationInfo : relation) {
            String[] infoParams = relationInfo.split(" - ");
            if (infoParams[0].equals(fullName) || infoParams[0].equals(fullPerson.birthday)) {
                // We found a child
                String[] childParams = infoParams[1].split(" ");
                if (childParams.length == 1) {
                    fullPerson.children.add(people.get(childParams[0]));
                } else if (childParams.length == 2) {
                    for (Person person : people.values()) {
                        if (person.firstName.equals(childParams[0]) && person.lastName.equals(childParams[1])) {
                            fullPerson.children.add(person);
                        }
                    }
                }
            } else if (infoParams[1].equals(fullName) || infoParams[1].equals(fullPerson.birthday)) {
                // We found a parent
                String[] parentParams = infoParams[0].split(" ");
                if (parentParams.length == 1) {
                    fullPerson.parents.add(people.get(parentParams[0]));
                } else if (parentParams.length == 2) {
                    for (Person person : people.values()) {
                        if (person.firstName.equals(parentParams[0]) && person.lastName.equals(parentParams[1])) {
                            fullPerson.parents.add(person);
                        }
                    }
                }
            }
        }
        result.append(String.format("Parents:%s", System.lineSeparator()));
        for (Person parent : fullPerson.parents) {
            result.append(String.format("%s%s", parent, System.lineSeparator()));
        }
        result.append(String.format("Children:%s", System.lineSeparator()));
        for (Person child : fullPerson.children) {
            result.append(String.format("%s%s", child, System.lineSeparator()));
        }

        System.out.println(result);
    }

    static class Person {
        String firstName;
        String lastName;
        String birthday;
        List<Person> parents;
        List<Person> children;

        Person(String firstName, String lastName, String birthday) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthday = birthday;
            this.parents = new LinkedList<>();
            this.children = new LinkedList<>();
        }

        Person(String firstName, String lastName) {
            this(firstName, lastName, null);
        }

        Person(String birthday) {
            this(null, null, birthday);
        }

        Person() {
            this(null, null, null);
        }

        public String toString() {
            return String.format("%s %s %s", firstName, lastName, birthday);
        }
    }
}

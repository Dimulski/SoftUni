package Problem2OldestFamilyMember;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public class OldestFamilyMember {

    public static void main(String[] args) throws IOException, NoSuchMethodException {

        Method getOldestMethod = Family.class.getMethod("getOldestMember");
        Method addMemberMethod = Family.class.getMethod("addMember", Person.class);

        Family family = new Family();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] lineParams = reader.readLine().split(" ");
            String name = lineParams[0];
            Integer age = Integer.parseInt(lineParams[1]);
            Person person = new Person(name, age);
            family.addMember(person);
        }
        System.out.println(family.getOldestMember());
    }
}

class Person {
    String name;
    Integer age;

    Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return String.format("%s %s", this.name, this.age);
    }
}

class Family {
    List<Person> members;
    Person oldestMember;

    Family() {
        this.members = new LinkedList<>();
    }

    public void addMember(Person person) {
        this.members.add(person);
        if (this.members.size() == 1) {
            oldestMember = person;
        } else {
            if (person.age > oldestMember.age) {
                oldestMember = person;
            }
        }
    }

    public Person getOldestMember() {
        return oldestMember;
    }
}

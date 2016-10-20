package Problem9Google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Google { // #firstTry

    public static void main(String[] args) throws IOException {

        HashMap<String, Person> people = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            String[] lineParams = line.split(" ");
            String name = lineParams[0];
            if (!people.containsKey(name)) {
                people.put(name, new Person(name));
                people.get(name).parents = new LinkedList<>();
                people.get(name).children = new LinkedList<>();
                people.get(name).pocketMonsters = new LinkedList<>();
            }

            switch (lineParams[1]) {
                case "company": {
                    String companyName = lineParams[2];
                    String department = lineParams[3];
                    Double salary = Double.parseDouble(lineParams[4]);
                    people.get(name).company = new Company(companyName, department, salary);
                    break;
                }
                case "car": {
                    String carModel = lineParams[2];
                    Integer carSpeed = Integer.parseInt(lineParams[3]);
                    people.get(name).car = new Car(carModel, carSpeed);
                    break;
                }
                case "parents": {
                    String parentName = lineParams[2];
                    String parentBirthday = lineParams[3];
                    people.get(name).parents.add(new Parent(parentName, parentBirthday));
                    break;
                }
                case "children": {
                    String childName = lineParams[2];
                    String childBirthday = lineParams[3];
                    people.get(name).children.add(new Child(childName, childBirthday));
                    break;
                }
                case "pokemon": {
                    String pokemonName = lineParams[2];
                    String pokemonType = lineParams[3];
                    people.get(name).pocketMonsters.add(new Pokemon(pokemonName, pokemonType));
                    break;
                }
            }
        }

        String targetPerson = reader.readLine();
        System.out.println(people.get(targetPerson).toString());

    }

    static class Person {
        String name;
        Company company;
        Car car;
        List<Parent> parents;
        List<Child> children;
        List<Pokemon> pocketMonsters;

        Person(String name, Company company, Car car, List<Parent> parents, List<Child> children, List<Pokemon> pocketMonsters) {
            this.name = name;
            this.company = company;
            this.car = car;
            this.parents = parents;
            this.children = children;
            this.pocketMonsters = pocketMonsters;
        }
        Person(String name) {
            this(name, null, null, null, null, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%s%s", this.name, System.lineSeparator()));
            sb.append(String.format("Company:%s", System.lineSeparator()));
            if (company != null) {
                sb.append(String.format("%s%s", company.toString(), System.lineSeparator()));
            }
            sb.append(String.format("Car:%s", System.lineSeparator()));
            if (car != null) {
                sb.append(String.format("%s%s", car.toString(), System.lineSeparator()));
            }
            sb.append(String.format("Pokemon:%s", System.lineSeparator()));
            for (Pokemon pokemon : pocketMonsters) {
                sb.append(String.format("%s%s", pokemon.toString(), System.lineSeparator()));
            }
            sb.append(String.format("Parents:%s", System.lineSeparator()));
            for (Parent parent : parents) {
                sb.append(String.format("%s%s", parent.toString(), System.lineSeparator()));
            }
            sb.append(String.format("Children:%s", System.lineSeparator()));
            for (Child child : children) {
                sb.append(String.format("%s%s", child.toString(), System.lineSeparator()));
            }
            return sb.toString();
        }
    }

    static class Company { // the department and salary should be Person fields.
        String name;
        String department;
        Double salary;

        Company(String name, String department, Double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String toString() {
            return String.format("%s %s %.2f", this.name, this.department, this.salary);
        }
    }

    static class Car {
        String model;
        Integer speed;

        Car(String model, Integer speed) {
            this.model = model;
            this.speed = speed;
        }

        public String toString() {
            return String.format("%s %d", this.model, this.speed);
        }
    }

    static class Parent {
        String name;
        String birthday; // This should obviously be DateTime.

        Parent(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        public String toString() {
            return String.format("%s %s", this.name, this.birthday);
        }
    }

    static class Child {
        String name;
        String birthday; // This should obviously be DateTime.

        Child(String name, String birthday) {
            this.name = name;
            this.birthday = birthday;
        }

        public String toString() {
            return String.format("%s %s", this.name, this.birthday);
        }
    }
    static class Pokemon {
        String name;
        String type;

        Pokemon(String name, String type) {
            this.name = name;
            this.type = type;
        }

        public String toString() {
            return String.format("%s %s", this.name, this.type);
        }
    }
}

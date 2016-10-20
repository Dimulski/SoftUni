package problem5ComparingObjects;

interface Person extends Comparable<Person> {

    String getName();

    Integer getAge();

    String getTown();
}

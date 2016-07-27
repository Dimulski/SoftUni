package problem5ComparingObjects;

public class PersonImpl implements Person {

    private String name;
    private Integer age;
    private String town;

    PersonImpl(String name, Integer age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public String getTown() {
        return this.town;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person otherPerson) {
        int compareNames = this.getName().compareTo(otherPerson.getName());
        if (compareNames != 0) {
            return compareNames;
        } else {
            int compareAge = this.getAge().compareTo(otherPerson.getAge());
            if (compareAge != 0) {
                return compareAge;
            } else {
                return this.getTown().compareTo(otherPerson.getTown());
            }
        }
    }
}

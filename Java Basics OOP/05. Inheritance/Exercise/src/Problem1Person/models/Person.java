package Problem1Person.models;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.setName(name);
        this.setAge(age);
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    private Integer getAge() {
        return this.age;
    }

    protected void setAge(Integer age) {
        if (age < 1) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s, Age: %d",
                this.getName(),
                this.getAge()));

        return stringBuilder.toString();
    }
}

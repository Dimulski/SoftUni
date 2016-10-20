package Problem6Animals.models;

import Problem6Animals.interfaces.ISoundProducible;

public class Animal implements ISoundProducible{

    private String name;
    private Integer age;
    private String gender;

    public Animal(String name, Integer age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    private Integer getAge() {
        return this.age;
    }

    private void setAge(Integer age) {
        if (age == null || age < 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    private String getGender() {
        return this.gender;
    }

    private void setGender(String gender) {
        if (!gender.equals("Male") && !gender.equals("Female")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    @Override
    public String produceSound() {
        return "Not implemented!";
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        output.append(String.format("%s %d %s", this.name, this.age, this.gender));
        return output.toString();
    }
}

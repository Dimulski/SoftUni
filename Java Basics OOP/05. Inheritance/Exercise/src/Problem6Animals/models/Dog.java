package Problem6Animals.models;

public class Dog extends Animal {

    public Dog(String name, Integer age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }
}

package Problem6Animals.models;

public class Kitten extends Cat {

    public Kitten(String name, Integer age) {
        super(name, age, "Female");
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}

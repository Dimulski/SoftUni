package Problem6Animals.models;

public class Tomcat extends Cat {

    public Tomcat(String name, Integer age) {
        super(name, age, "Male");
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}

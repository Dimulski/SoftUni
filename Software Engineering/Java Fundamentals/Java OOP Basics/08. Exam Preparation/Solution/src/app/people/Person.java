package app.people;

/**
 * Created by RoYaL on 7/6/2016.
 */
public class Person {

    private double income;

    public Person(double income) {
        this.setIncome(income);
    }

    public double getIncome() {
        return income;
    }

    private void setIncome(double income) {
        this.income = income;
    }
}

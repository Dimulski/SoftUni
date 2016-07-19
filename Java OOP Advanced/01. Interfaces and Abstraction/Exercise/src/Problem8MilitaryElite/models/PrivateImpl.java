package Problem8MilitaryElite.models;

import Problem8MilitaryElite.contracts.Private;

public class PrivateImpl extends Soldier implements Private {

    private Double salary;

    public PrivateImpl(Integer id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName);
        this.setSalary(salary);
    }

    private void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" Salary: %.2f%s", getSalary(), System.lineSeparator());
    }
}

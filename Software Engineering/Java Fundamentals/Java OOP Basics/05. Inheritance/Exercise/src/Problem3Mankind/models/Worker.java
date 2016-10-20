package Problem3Mankind.models;

public class Worker extends Human {
    private Double weekSalary;
    private Double workHoursPerDay;
    private Double salaryPerHour;

    public Worker(String fistName, String lastName, Double weekSalary, Double workHoursPerDay) {
        super(fistName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
        this.setSalaryPerHour();
    }

    private Double getSalaryPerHour() {
        return this.salaryPerHour;
    }

    private void setSalaryPerHour() {
        this.salaryPerHour = (getWeekSalary() / 7) / getWorkHoursPerDay();
    }

    private Double getWeekSalary() {
        return this.weekSalary;
    }

    private void setWeekSalary(Double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private Double getWorkHoursPerDay() {
        return this.workHoursPerDay;
    }

    private void setWorkHoursPerDay(Double workHoursPerDay) {
        if (workHoursPerDay < 1 || workHoursPerDay > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workHoursPerDay = workHoursPerDay;
    }

    @Override
    public String toString() {
        String result = super.toString() +
                String.format("Week Salary: %.2f%s", getWeekSalary(), System.lineSeparator()) +
                String.format("Hours per day: %.2f%s", getWorkHoursPerDay(), System.lineSeparator()) +
                String.format("Salary per hour: %.2f%s", getSalaryPerHour(), System.lineSeparator());
        return result;
    }
}

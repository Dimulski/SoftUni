package Problem3Mankind.models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Human {
    private String facultyNumber;

    public Student(String fistName, String lastName, String facultyNumber) {
        super(fistName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private String getFacultyNumber() {
        return this.facultyNumber;
    }
    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() < 5 || facultyNumber.length() > 10 || !this.isFacultyNumberValid(facultyNumber)) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    private boolean isFacultyNumberValid(String facultyNumber) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(facultyNumber);
        return matcher.matches();
    }

    @Override
    public String toString() {
        String result = super.toString() +
                String.format("Faculty number: %s%s", getFacultyNumber(), System.lineSeparator());
        return result;
    }
}

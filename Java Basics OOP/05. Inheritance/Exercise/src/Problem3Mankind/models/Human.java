package Problem3Mankind.models;

public class Human {
    private String firstName;
    private String lastName;

    Human(String fistName, String lastName) {
        this.setFirstName(fistName);
        this.setLastName(lastName);
    }

    private String getFirstName() {
        return this.firstName;
    }

    private void setFirstName(String firstName) {
        if (Character.isLowerCase(firstName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName"); // Exception messages should be extracted in a class
        }
        if (firstName.length() < 4) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    private void setLastName(String lastName) {
        if (Character.isLowerCase(lastName.charAt(0))) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (lastName.length() < 3) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        String result = String.format("First Name: %s%s", getFirstName(), System.lineSeparator()) +
                String.format("Last Name: %s%s", getLastName(), System.lineSeparator());
        return result;
    }
}

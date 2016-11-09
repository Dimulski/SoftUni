package entities;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;

public class Student{

    private int id;

    private String firstName;

    private Date registrationDate;

    public Student() {
    }

    public Student(String firstName, Date registrationDate) {
        this.firstName = firstName;
        this.registrationDate = registrationDate;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

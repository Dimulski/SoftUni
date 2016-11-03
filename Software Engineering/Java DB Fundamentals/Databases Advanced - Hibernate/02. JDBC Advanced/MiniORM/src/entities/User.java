package entities;

import persistence.Column;
import persistence.Entity;
import persistence.Id;

import java.util.Date;


@Entity(name = "users")
public class User {

    @Id
    private int id;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public User(String password, int age, Date registrationDate) {
        this.setPassword(password);
        this.setAge(age);
        this.setRegistrationDate(registrationDate);
    }
}

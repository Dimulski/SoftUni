package models;


import persistance.Column;
import persistance.Entity;
import persistance.Id;

import java.util.Date;

@Entity(name = "users")
public class User {

    @Id
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    @SuppressWarnings("unused")
    public User() {
        super();
    }

    public User(String name, int age, Date registrationDate) {
        this.setName(name);
        this.setAge(age);
        this.setRegistrationDate(registrationDate);
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}

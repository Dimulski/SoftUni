package entities;

import persistence.Column;
import persistence.Entity;
import persistence.Id;

import java.util.Date;

@Entity(name = "users")
public class User {

    @Id
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    public User(String username, String password, int age, Date registrationDate) {
        this.setUsername(username);
        this.setPassword(password);
        this.setAge(age);
        this.setRegistrationDate(registrationDate);
    }

    public User() {
        super();
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    private void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return String.format("Id: %s, Username: %s, Age: %d, Registration Date: %s",
                this.getId(),
                this.getUsername(),
                this.getAge(),
                this.getRegistrationDate());
    }
}

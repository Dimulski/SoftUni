package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final int MAX_PICTURE_SIZE = 20000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(columnDefinition = "LONGBLOB")
    private byte[] profilePicture;

    @Basic
    private Date registeredOn;

    @Basic
    private Date lastTimeLoggedIn;

    @Basic
    private int age;

    @Basic
    private boolean isDeleted;

    public User() {
        super();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        if (userName.length() < 4 || userName.length() > 30) {
            throw new IllegalArgumentException("Invalid username length");
        }

        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if (!this.validatePattern(password, PASSWORD_PATTERN)) {
            throw new IllegalArgumentException("Invalid password");
        }

        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if (!this.validatePattern(email, EMAIL_PATTERN)) {
            throw new IllegalArgumentException("Invalid email");
        }

        this.email = email;
    }

    public byte[] getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        if (profilePicture.length > MAX_PICTURE_SIZE) {
            throw new IllegalArgumentException("Profile picture is too big");
        }

        this.profilePicture = profilePicture;
    }

    public Date getRegisteredOn() {
        return this.registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Date getLastTimeLoggedIn() {
        return this.lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Invalid age");
        }

        this.age = age;
    }

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    private boolean validatePattern(String item, String pattern) {
        Pattern patternValidator = Pattern.compile(pattern);
        Matcher matcher = patternValidator.matcher(item);
        return matcher.find();
    }
}

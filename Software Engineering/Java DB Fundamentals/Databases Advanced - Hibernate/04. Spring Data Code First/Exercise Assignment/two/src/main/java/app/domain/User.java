package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name = "users")
public class User implements Serializable{

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "profile_picture", columnDefinition = "LONGBLOB")
    private byte[] profilePicture;

    @Column(name = "registered_on")
    private Date registeredOn;

    @Column(name = "last_time_logged_in")
    private Date lastTimeLoggedIn;

    @Basic
    private int age;

    @Column(name = "is_deleted")
    private boolean deleted;

    public User() {
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
        if(userName.length() < 4 || userName.length() >30){
            throw new IllegalArgumentException("Invalid User Name");
        }

        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if(!this.validatePattern(password, PASSWORD_PATTERN)){
            throw new IllegalArgumentException("Invalid Password");
        }

        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        if(!this.validatePattern(email, EMAIL_PATTERN)){
            throw new IllegalArgumentException("Invalid Email");
        }

        this.email = email;
    }

    public byte[] getProfilePicture() {
        return this.profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        if(profilePicture.length > 1024*1024){
            throw new IllegalArgumentException("Profile Pic too big");
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
        if(age <1 || age > 120){
            throw new IllegalArgumentException("Invalid age");
        }

        this.age = age;
    }

    public boolean getIsDeleted(){
        return this.deleted;
    }

    public void setIsDeleted(boolean isDeleted){
        this.deleted=isDeleted;
    }

    private boolean validatePattern(String item, String pattern){
        Pattern patternValidator = Pattern.compile(pattern);
        Matcher matcher = patternValidator.matcher(item);
        if(matcher.find()){
            return true;
        }

        return false;
    }
}

package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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

    @Basic
    private String firstName;

    @Basic
    private String lastName;

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

    @ManyToOne
    @JoinColumn(name = "born_town_id", referencedColumnName = "id")
    private Town placeOfBirth;

    @ManyToOne
    @JoinColumn(name = "town_of_residence_id", referencedColumnName = "id")
    private Town townOfResidence;

    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;

    @ManyToMany(mappedBy = "friends", targetEntity = User.class)
    private Set<User> users;

    public User() {
        this.setFriends(new HashSet<>());
        this.setUsers(new HashSet<>());
    }

    public User(String userName, String firstName, String lastName, String password,
                String email, byte[] profilePicture, Date registeredOn, Date lastTimeLoggedIn,
                int age, boolean isDeleted, Town placeOfBirth, Town townOfResidence) {
        this();
        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassword(password);
        this.setEmail(email);
        this.setProfilePicture(profilePicture);
        this.setRegisteredOn(registeredOn);
        this.setLastTimeLoggedIn(lastTimeLoggedIn);
        this.setAge(age);
        this.setIsDeleted(isDeleted);
        this.setPlaceOfBirth(placeOfBirth);
        this.setTownOfResidence(townOfResidence);
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Town getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(Town placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Town getTownOfResidence() {
        return townOfResidence;
    }

    public void setTownOfResidence(Town townOfResidence) {
        this.townOfResidence = townOfResidence;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Transient
    public String getFullName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    private boolean validatePattern(String item, String pattern) {
        Pattern patternValidator = Pattern.compile(pattern);
        Matcher matcher = patternValidator.matcher(item);
        return matcher.find();
    }
}

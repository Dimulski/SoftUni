package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String userName;

    @Basic
    private String firstName;

    @Basic
    private String lastName;

    @Basic
    private String password;

    @Basic
    private String email;

    @Basic
    private Date registeredOn;

    @Basic
    private Date lastTimeLoggedIn;

    @Basic
    private int age;

    @OneToOne
    @JoinColumn(name = "picture_id", referencedColumnName = "id")
    private Picture profilePicture;

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

    @ManyToMany
    @JoinTable(name = "users_albums",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"))
    private Set<Album> albums;

    public User() {
        this.setFriends(new HashSet<>());
        this.setUsers(new HashSet<>());
        this.setAlbums(new HashSet<>());
    }

    public User(String userName, String firstName, String lastName, String password,
                String email, Date registeredOn, Date lastTimeLoggedIn, int age,
                Picture profilePicture, boolean isDeleted, Town placeOfBirth, Town townOfResidence) {
        this();
        this.setUserName(userName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPassword(password);
        this.setEmail(email);
        this.setRegisteredOn(registeredOn);
        this.setLastTimeLoggedIn(lastTimeLoggedIn);
        this.setAge(age);
        this.setProfilePicture(profilePicture);
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
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        this.age = age;
    }

    public Picture getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(Picture profilePicture) {
        this.profilePicture = profilePicture;
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

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public void addFriend(User friend) {
        this.getFriends().add(friend);
    }
}

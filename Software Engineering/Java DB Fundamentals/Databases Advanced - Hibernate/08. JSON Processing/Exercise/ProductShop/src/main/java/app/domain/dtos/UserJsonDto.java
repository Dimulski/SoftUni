package app.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserJsonDto implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    private Set<UserJsonDto> friends;

    @Expose
    private Set<ProductJsonDto> sellProducts;

    public UserJsonDto() {
        super();
    }

    public UserJsonDto(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<UserJsonDto> getFriends() {
        if (this.friends == null) {
            this.setFriends(new HashSet<>());
        }

        return friends;
    }

    public void setFriends(Set<UserJsonDto> friends) {
        this.friends = friends;
    }

    public Set<ProductJsonDto> getSellProducts() {
        if (this.sellProducts == null) {
            this.setSellProducts(new HashSet<>());
        }

        return sellProducts;
    }

    public void setSellProducts(Set<ProductJsonDto> sellProducts) {
        this.sellProducts = sellProducts;
    }
}

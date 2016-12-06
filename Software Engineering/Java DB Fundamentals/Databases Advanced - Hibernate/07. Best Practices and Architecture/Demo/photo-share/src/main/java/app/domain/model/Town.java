package app.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town {
    private Integer id;
    private String name;
    private String country;
    private Set<User> usersBornInTown;
    private Set<User> usersCurrentlyLivingInTown;

    @Id
    @Column(name = "town_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bornTown")
    public Set<User> getUsersBornInTown() {
        return usersBornInTown;
    }

    public void setUsersBornInTown(Set<User> usersBornInTown) {
        this.usersBornInTown = usersBornInTown;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currentTown")
    public Set<User> getUsersCurrentlyLivingInTown() {
        return usersCurrentlyLivingInTown;
    }

    public void setUsersCurrentlyLivingInTown(Set<User> usersCurrentlyLivingInTown) {
        this.usersCurrentlyLivingInTown = usersCurrentlyLivingInTown;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", this.getName(), this.getCountry());
    }
}

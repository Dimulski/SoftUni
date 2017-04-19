package softuni.areas.users.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    private Integer id;

    private String name;

    private Set<User> users;

    public Role() {
        this.users = new HashSet<>();
    }

    public Role(String role) {
        this.setName(role);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Transient
    public String getSimpleName(){
        return StringUtils.capitalize(this.getName().substring(5).toLowerCase());
    }

    @Transient
    @Override
    public String getAuthority() {
        return this.getName();
    }
}
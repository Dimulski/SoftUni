package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towns")
public class Town implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "hostTown", targetEntity = Team.class)
    private Set<Team> hostedTeams;

    public Town() {
        this.hostedTeams = new HashSet<>();
    }

    public Town(String name, Country country) {
        this();
        this.setName(name);
        this.setCountry(country);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Set<Team> getHostedTeams() {
        return hostedTeams;
    }

    public void setHostedTeams(Set<Team> hostedTeams) {
        this.hostedTeams = hostedTeams;
    }
}

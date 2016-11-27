package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
public class Country implements Serializable {

    @Id
    @Column(length = 3)
    private String id;

    @Basic
    private String name;

    @ManyToMany
    @JoinTable(name = "countries_continents",
    joinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "continent_id", referencedColumnName = "id"))
    private Set<Continent> continents;

    @OneToMany(mappedBy = "country", targetEntity = Town.class)
    private Set<Town> towns;

    public Country() {
        this.continents = new HashSet<>();
        this.towns = new HashSet<>();
    }

    public Country(String id, String name) {
        this();
        this.setId(id);
        this.setName(name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Continent> getContinents() {
        return continents;
    }

    public void setContinents(Set<Continent> continents) {
        this.continents = continents;
    }

    public Set<Town> getTowns() {
        return towns;
    }

    public void setTowns(Set<Town> towns) {
        this.towns = towns;
    }
}

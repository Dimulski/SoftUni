package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "countries")
public class Country implements Serializable {

    @Id
    @Column(length = 3)
    private String id;

    @Basic
    private String name;

    @Basic
    private Continent continent;

    public Country() {
        super();
    }

    public Country(String id, String name, Continent continent) {
        this.setId(id);
        this.setName(name);
        this.setContinent(continent);
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }
}

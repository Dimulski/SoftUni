package com.softuni.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "part_suppliers")
public class PartSupplier {

    private Long id;
    private String name;
    private Boolean isImporter;
    private Set<Part> parts;

    public PartSupplier() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }

    @OneToMany(mappedBy = "supplier",orphanRemoval = true,cascade = CascadeType.ALL)
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}

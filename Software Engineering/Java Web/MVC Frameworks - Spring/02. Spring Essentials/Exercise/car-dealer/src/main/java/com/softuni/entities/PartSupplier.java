package com.softuni.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "part_suppliers")
public class PartSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isImporter;

    @OneToMany(mappedBy = "supplier", targetEntity = Part.class)
    private Set<Part> parts;

    public PartSupplier() {

    }

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

    public Boolean getIsImporter() {
        return isImporter;
    }

    public void setIsImporter(Boolean isImporter) {
        this.isImporter = isImporter;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}

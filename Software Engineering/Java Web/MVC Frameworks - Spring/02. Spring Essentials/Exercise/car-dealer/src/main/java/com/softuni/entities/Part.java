package com.softuni.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    @ManyToMany(mappedBy = "parts" ,cascade = CascadeType.ALL)
    private Set<Car> cars;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private PartSupplier supplier;

    public Part() {

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public PartSupplier getSupplier() {
        return supplier;
    }

    public void setSupplier(PartSupplier supplier) {
        this.supplier = supplier;
    }
}

package com.softuni.models.bindingModels.part;

import com.softuni.models.bindingModels.partSupplier.PartSupplierModel;

public class EditPartModel {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private PartSupplierModel partSupplier;

    public EditPartModel() {

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

    public PartSupplierModel getPartSupplier() {
        return partSupplier;
    }

    public void setPartSupplier(PartSupplierModel partSupplier) {
        this.partSupplier = partSupplier;
    }
}

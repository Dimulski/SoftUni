package com.softuni.models.bindingModels.part;

import com.softuni.models.bindingModels.partSupplier.PartSupplierModel;

public class AddPartModel {

    private String name;
    private Double price;
    private Integer quantity;
    private PartSupplierModel supplier;

    public AddPartModel() {

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

    public PartSupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(PartSupplierModel supplier) {
        this.supplier = supplier;
    }
}

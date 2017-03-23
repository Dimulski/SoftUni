package com.softuni.models.bindingModels.sale;

import com.softuni.models.bindingModels.car.RelatedCarModel;
import com.softuni.models.bindingModels.customer.RelatedCustomerModel;

public class SaleModel {

    private Double discount;
    private RelatedCustomerModel customer;
    private RelatedCarModel car;

    public SaleModel() {
        
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public RelatedCustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(RelatedCustomerModel customer) {
        this.customer = customer;
    }

    public RelatedCarModel getCar() {
        return car;
    }

    public void setCar(RelatedCarModel car) {
        this.car = car;
    }
}

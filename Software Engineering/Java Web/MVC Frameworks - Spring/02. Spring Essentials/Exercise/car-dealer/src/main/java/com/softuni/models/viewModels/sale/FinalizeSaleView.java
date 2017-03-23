package com.softuni.models.viewModels.sale;

import com.softuni.models.viewModels.car.CarWithPartsView;
import com.softuni.models.viewModels.customer.CustomerDriverView;

public class FinalizeSaleView {

    private Double discount;
    private CarWithPartsView car;
    private CustomerDriverView customer;
    private Double carPrice;
    private Double finalCarPrice;

    public FinalizeSaleView() {
        
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public CarWithPartsView getCar() {
        return car;
    }

    public void setCar(CarWithPartsView car) {
        this.car = car;
    }

    public CustomerDriverView getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDriverView customer) {
        this.customer = customer;
    }

    public Double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(Double carPrice) {
        this.carPrice = carPrice;
    }

    public Double getFinalCarPrice() {
        return finalCarPrice;
    }

    public void setFinalCarPrice(Double finalCarPrice) {
        this.finalCarPrice = finalCarPrice;
    }
}

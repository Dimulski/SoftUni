package com.softuni.models.viewModels.customer;

import com.softuni.models.viewModels.sale.SaleView;

import java.util.Set;

public class CustomerDetailsView {

    private String name;
    private Boolean isYoungDriver;
    private Set<SaleView> sales;
    private Double totalSum;

    public CustomerDetailsView() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<SaleView> getSales() {
        return sales;
    }

    public void setSales(Set<SaleView> sales) {
        this.sales = sales;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Boolean getIsYoungDriver() {
        return isYoungDriver;
    }

    public void setIsYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}

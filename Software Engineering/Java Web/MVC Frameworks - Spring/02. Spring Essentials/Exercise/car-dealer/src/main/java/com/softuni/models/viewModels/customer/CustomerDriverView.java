package com.softuni.models.viewModels.customer;

public class CustomerDriverView {

    private String name;
    private Boolean isYoungDriver;

    public CustomerDriverView() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsYoungDriver() {
        return isYoungDriver;
    }

    public void setIsYoungDriver(Boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}

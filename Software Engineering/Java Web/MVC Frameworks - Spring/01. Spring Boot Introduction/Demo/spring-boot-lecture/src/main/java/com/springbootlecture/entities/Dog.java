package com.springbootlecture.entities;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// @Component - one way of creating a Dog bean
public class Dog implements Animal {

    private String name;

    public Dog() {
        System.out.println("Initializing");
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

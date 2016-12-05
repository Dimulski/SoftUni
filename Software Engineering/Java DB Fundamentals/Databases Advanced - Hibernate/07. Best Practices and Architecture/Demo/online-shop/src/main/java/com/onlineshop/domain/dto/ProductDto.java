package com.onlineshop.domain.dto;

import java.math.BigDecimal;

public class ProductDto {

    private String name;

    private BigDecimal price;

    private long quantity;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}

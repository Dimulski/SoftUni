package com.thymeleaflecture.models;


import com.thymeleaflecture.annotations.ValidDouble;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class WhiskeyBindingModel {

    @NotBlank(message = "Name should not be blank")
    @Size(min = 5, max = 20)
    private String name;

    @Pattern(regexp = "\\d+\\.?\\d+", message = "Invalid Price")
    @Min(value = 10, message = "The whiskey cannot be that cheap")
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

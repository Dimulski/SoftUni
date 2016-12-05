package app.domain.factories;

import app.domain.models.Product;

import java.math.BigDecimal;

public class ProductFactory {

    public Product create(String name, BigDecimal price){
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}

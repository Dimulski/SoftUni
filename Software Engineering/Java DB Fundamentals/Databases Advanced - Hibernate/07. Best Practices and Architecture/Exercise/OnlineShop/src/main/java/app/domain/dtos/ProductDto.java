package app.domain.dtos;

import java.math.BigDecimal;

public class ProductDto {

    private String name;

    private BigDecimal price;

    private long quantity;

    public ProductDto() {
        super();
    }

    public ProductDto(String name, BigDecimal price, long quantity) {
        this.setName(name);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }
}

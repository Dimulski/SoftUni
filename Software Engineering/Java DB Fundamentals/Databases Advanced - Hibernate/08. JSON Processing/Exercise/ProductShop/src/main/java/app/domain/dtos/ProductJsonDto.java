package app.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductJsonDto implements Serializable {

    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    private UserJsonDto buyer;

    private UserJsonDto seller;

    private Set<CategoryJsonDto> categories;

    public ProductJsonDto() {
        super();
    }

    public ProductJsonDto(String name, BigDecimal price, UserJsonDto buyer, UserJsonDto seller) {
        this.setName(name);
        this.setPrice(price);
        this.setBuyer(buyer);
        this.setSeller(seller);
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

    public UserJsonDto getBuyer() {
        return buyer;
    }

    public void setBuyer(UserJsonDto buyer) {
        this.buyer = buyer;
    }

    public UserJsonDto getSeller() {
        return seller;
    }

    public void setSeller(UserJsonDto seller) {
        this.seller = seller;
    }

    public Set<CategoryJsonDto> getCategories() {
        if (this.categories == null) {
            this.setCategories(new HashSet<>());
        }

        return categories;
    }

    public void setCategories(Set<CategoryJsonDto> categories) {
        this.categories = categories;
    }
}

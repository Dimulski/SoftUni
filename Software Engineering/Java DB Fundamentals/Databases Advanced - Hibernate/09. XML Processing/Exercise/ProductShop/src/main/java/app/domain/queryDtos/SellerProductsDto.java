package app.domain.queryDtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SellerProductsDto implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private Set<ProductBuyerNamesDto> soldProducts;

    public SellerProductsDto() {
        super();
    }

    public SellerProductsDto(String firstName, String lastName, Set<ProductBuyerNamesDto> soldProducts) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSoldProducts(soldProducts);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<ProductBuyerNamesDto> getSoldProducts() {
        if (this.soldProducts == null) {
            this.setSoldProducts(new HashSet<>());
        }

        return soldProducts;
    }

    public void setSoldProducts(Set<ProductBuyerNamesDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}

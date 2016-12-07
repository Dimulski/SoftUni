package app.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class AddressJsonDto implements Serializable {

    @Expose
    private String country;

    @Expose
    private String city;

    public AddressJsonDto() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

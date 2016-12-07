package app.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class PersonJsonDto implements Serializable {

    @Expose
    private String firstName;

    @Expose
    private AddressJsonDto address;

    @Expose
    private Set<PhoneNumberJsonDto> phoneNumbers;

    public PersonJsonDto() {
        this.setPhoneNumbers(new HashSet<>());
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public AddressJsonDto getAddress () {
        return address;
    }

    public void setAddress(AddressJsonDto address) {
        this.address = address;
    }

    public Set<PhoneNumberJsonDto> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<PhoneNumberJsonDto> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}

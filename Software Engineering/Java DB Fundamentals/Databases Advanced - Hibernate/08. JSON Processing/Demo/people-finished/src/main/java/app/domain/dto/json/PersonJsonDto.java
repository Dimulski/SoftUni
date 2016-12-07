package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonJsonDto implements Serializable {

    @XmlElement
    @Expose
    private String firstName;

    @XmlElement
    @Expose
    private String lastName;

    @XmlElement
    @Expose
    private AddressJsonDto addressImportDto;

    @XmlElementWrapper
    @XmlElement
    @Expose
    private Set<PhoneJsonDto> phoneJsonDtos;

    public PersonJsonDto() {
        this.setPhoneJsonDtos(new HashSet<>());
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressJsonDto getAddressImportDto() {
        return this.addressImportDto;
    }

    public void setAddressImportDto(AddressJsonDto addressImportDto) {
        this.addressImportDto = addressImportDto;
    }

    public Set<PhoneJsonDto> getPhoneJsonDtos() {
        return this.phoneJsonDtos;
    }

    public void setPhoneJsonDtos(Set<PhoneJsonDto> phoneJsonDtos) {
        this.phoneJsonDtos = phoneJsonDtos;
    }
}

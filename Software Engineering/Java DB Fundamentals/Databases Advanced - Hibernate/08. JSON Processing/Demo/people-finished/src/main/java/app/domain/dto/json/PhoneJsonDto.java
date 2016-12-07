package app.domain.dto.json;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PhoneJsonDto implements Serializable {

    @XmlElement
    @Expose
    private String number;

    //@Expose
    @XmlTransient
    private PersonJsonDto personJsonDto;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonJsonDto getPersonJsonDto() {
        return this.personJsonDto;
    }

    public void setPersonJsonDto(PersonJsonDto personJsonDto) {
        this.personJsonDto = personJsonDto;
    }
}

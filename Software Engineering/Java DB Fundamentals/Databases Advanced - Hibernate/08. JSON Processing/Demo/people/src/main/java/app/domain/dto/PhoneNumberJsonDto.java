package app.domain.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class PhoneNumberJsonDto implements Serializable {

    @Expose
    private String number;

    private PersonJsonDto person;

    public PhoneNumberJsonDto() {
        super();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonJsonDto getPerson() {
        return person;
    }

    public void setPerson(PersonJsonDto person) {
        this.person = person;
    }
}

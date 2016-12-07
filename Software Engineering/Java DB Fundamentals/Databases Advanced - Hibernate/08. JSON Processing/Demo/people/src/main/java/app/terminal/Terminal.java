package app.terminal;

import app.domain.dto.AddressJsonDto;
import app.domain.dto.PersonJsonDto;
import app.domain.dto.PhoneNumberJsonDto;
import app.io.JSONParser;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    @Autowired
    private JSONParser jsonParser;

    @Override
    public void run(String... strings) throws Exception {
        this.writeSingleObjectToJson();
        this.writeManyObjectsToJson();
        this.readSingleObjectFromJson();
        this.readManyObjectsFromJson();
    }

    private void readSingleObjectFromJson() {
        try {
            PersonJsonDto personJsonDto = this.jsonParser
                    .read(PersonJsonDto.class, "/files/input/json/person.json");
            this.personService.create(personJsonDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readManyObjectsFromJson() {
        try {
            PersonJsonDto[] personJsonDtos = this.jsonParser
                    .read(PersonJsonDto[].class, "/files/input/json/persons.json");
            for (PersonJsonDto personJsonDto : personJsonDtos) {
                this.personService.create(personJsonDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeSingleObjectToJson() {
        PersonJsonDto personJsonDto = this.seedData();
        try {
            this.jsonParser.write(personJsonDto, "src/main/resources/files/output/json/person.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeManyObjectsToJson() {
        List<PersonJsonDto> personJsonDtoList = new ArrayList<>();
        PersonJsonDto personJsonDto1 = this.seedData();
        PersonJsonDto personJsonDto2 = this.seedData();
        PersonJsonDto personJsonDto3 = this.seedData();
        personJsonDtoList.add(personJsonDto1);
        personJsonDtoList.add(personJsonDto2);
        personJsonDtoList.add(personJsonDto3);
        try {
            this.jsonParser.write(personJsonDtoList, "src/main/resources/files/output/json/persons.json");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private PersonJsonDto seedData() {
        PersonJsonDto personJsonDto = new PersonJsonDto();
        personJsonDto.setFirstName("John");
        AddressJsonDto addressJsonDto = new AddressJsonDto();
        addressJsonDto.setCity("Plovdiv");
        addressJsonDto.setCountry("Bulgaria");
        personJsonDto.setAddress(addressJsonDto);
        PhoneNumberJsonDto phoneNumberJsonDto = new PhoneNumberJsonDto();
        phoneNumberJsonDto.setPerson(personJsonDto);
        phoneNumberJsonDto.setNumber("0898654321");
        personJsonDto.getPhoneNumbers().add(phoneNumberJsonDto);

        return personJsonDto;
    }
}

package app.terminal;

import app.domain.dto.json.AddressJsonDto;
import app.domain.dto.json.PersonJsonDto;
import app.io.JsonParser;
import app.io.XmlParser;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    @Autowired
    private JsonParser jsonParser;

    @Autowired
    private XmlParser xmlParser;

    @Override
    public void run(String... strings) throws Exception {
        this.exportJson();
        this.exportXML();
//        this.exportJsons();
//        this.importJson();
//        this.importJsons();
    }

    private void exportXML() {
        PersonJsonDto personJsonDto = this.personService.findById(1);
        try {
            long startTime = System.currentTimeMillis();
            this.xmlParser.writeXML(personJsonDto, "src/main/resources/files/output/xml/person.xml");
            long endTime = System.currentTimeMillis();
            double time = (endTime - startTime);
            System.out.println("XML " + time);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void exportJson(){
        PersonJsonDto personJsonDto = this.personService.findById(1);
        try {
            long startTime = System.currentTimeMillis();
            this.jsonParser.exportJson(personJsonDto, "src/main/resources/files/output/json/person.json");
            long endTime = System.currentTimeMillis();
            double time = (endTime - startTime);
            System.out.println("JSON " + time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void exportJsons(){
        List<PersonJsonDto> personJsonDto = this.personService.findByCountry("Bulgaria");
        try {
            this.jsonParser.exportJson(personJsonDto, "src/main/resources/files/output/json/persons.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importJson(){
        try {
            PersonJsonDto personJsonDto = this.jsonParser.importJson(PersonJsonDto.class, "/files/input/json/person.json");
            this.personService.create(personJsonDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importJsons(){
        try {
            PersonJsonDto[] personJsonDtos = null;
            personJsonDtos = this.jsonParser.importJson(PersonJsonDto[].class, "/files/input/json/persons.json");
            for (PersonJsonDto personJsonDto : personJsonDtos) {
                this.personService.create(personJsonDto);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

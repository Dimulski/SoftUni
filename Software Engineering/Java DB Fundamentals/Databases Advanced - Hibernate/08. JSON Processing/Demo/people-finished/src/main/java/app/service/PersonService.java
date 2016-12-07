package app.service;

import app.domain.dto.json.PersonJsonDto;
import app.domain.model.Person;

import java.util.List;

public interface PersonService {

    void create(PersonJsonDto person);

    PersonJsonDto findById(long id);

    List<PersonJsonDto> findByCountry(String country);
}

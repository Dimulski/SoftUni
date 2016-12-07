package app.service;

import app.domain.dto.PersonJsonDto;

import java.util.List;

public interface PersonService {

    void create(PersonJsonDto personJsonDto);

    PersonJsonDto findById(long id);

    List<PersonJsonDto> findByCountry(String country);
}

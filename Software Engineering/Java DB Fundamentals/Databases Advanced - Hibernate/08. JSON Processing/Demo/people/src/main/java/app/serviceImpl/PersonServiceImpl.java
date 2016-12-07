package app.serviceImpl;

import app.domain.dto.AddressJsonDto;
import app.domain.dto.PersonJsonDto;
import app.domain.dto.PhoneNumberJsonDto;
import app.domain.model.Address;
import app.domain.model.Person;
import app.domain.model.PhoneNumber;
import app.repository.PersonRepository;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void create(PersonJsonDto personJsonDto) {
        Person person = this.convertToEntity(personJsonDto);
        this.personRepository.saveAndFlush(person);
    }

    @Override
    public PersonJsonDto findById(long id) {
        Person person = this.personRepository.findOne(id);
        PersonJsonDto personJsonDto = this.convertToDto(person);
        return personJsonDto;
    }

    @Override
    public List<PersonJsonDto> findByCountry(String country) {
        List<Person> persons = this.personRepository.findByCountry(country);
        List<PersonJsonDto> personJsonDtos = new ArrayList<>();
        for (Person person : persons) {
            PersonJsonDto personJsonDto = this.convertToDto(person);
            personJsonDtos.add(personJsonDto);
        }

        return personJsonDtos;
    }

    private PersonJsonDto convertToDto(Person person) {
        PersonJsonDto personJsonDto = new PersonJsonDto();
        personJsonDto.setFirstName(person.getFirstName());
        AddressJsonDto addressJsonDto = new AddressJsonDto();
        addressJsonDto.setCountry(person.getAddress().getCountry());
        addressJsonDto.setCountry(person.getAddress().getCity());
        personJsonDto.setAddress(addressJsonDto);
        Set<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
        for (PhoneNumber phoneNumber : phoneNumbers) {
            PhoneNumberJsonDto phoneNumberJsonDto = new PhoneNumberJsonDto();
            phoneNumberJsonDto.setNumber(phoneNumber.getNumber());
            phoneNumberJsonDto.setPerson(personJsonDto);
            personJsonDto.getPhoneNumbers().add(phoneNumberJsonDto);
        }

        return personJsonDto;
    }

    private Person convertToEntity(PersonJsonDto personJsonDto) {
        Person person = new Person();
        person.setFirstName(personJsonDto.getFirstName());
        Address address = new Address();
        address.setCountry(personJsonDto.getAddress().getCountry());
        address.setCity(personJsonDto.getAddress().getCity());
        person.setAddress(address);
        Set<PhoneNumberJsonDto> phoneNumberJsonDtos = personJsonDto.getPhoneNumbers();
        for (PhoneNumberJsonDto phoneNumberJsonDto : phoneNumberJsonDtos) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setNumber(phoneNumberJsonDto.getNumber());
            phoneNumber.setPerson(person);
            person.getPhoneNumbers().add(phoneNumber);
        }

        return person;
    }
}

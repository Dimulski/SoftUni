package app.serviceImpl;

import app.domain.dto.json.AddressJsonDto;
import app.domain.dto.json.PersonJsonDto;
import app.domain.dto.json.PhoneJsonDto;
import app.domain.model.Address;
import app.domain.model.Person;
import app.domain.model.PhoneNumber;
import app.repository.PersonRepository;
import app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Transactional
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

    private Person convertToEntity(PersonJsonDto personJsonDto){
        Person person = new Person();
        Address address = new Address();
        address.setCountry(personJsonDto.getAddressImportDto().getCountry());
        address.setCity(personJsonDto.getAddressImportDto().getCity());
        address.setStreet(personJsonDto.getAddressImportDto().getStreet());
        Set<PhoneJsonDto> phoneJsonDtos = personJsonDto.getPhoneJsonDtos();
        for (PhoneJsonDto phoneJsonDto : phoneJsonDtos) {
            PhoneNumber phoneNumber = new PhoneNumber();
            phoneNumber.setNumber(phoneJsonDto.getNumber());
            phoneNumber.setPerson(person);
            person.getPhoneNumbers().add(phoneNumber);
        }

        person.setFirstName(personJsonDto.getFirstName());
        person.setLastName(personJsonDto.getLastName());
        person.setAddress(address);
        return person;
    }

    private PersonJsonDto convertToDto(Person person){
        PersonJsonDto personJsonDto = new PersonJsonDto();
        AddressJsonDto addressJsonDto = new AddressJsonDto();
        personJsonDto.setFirstName(person.getFirstName());
        personJsonDto.setLastName(person.getLastName());
        addressJsonDto.setCountry(person.getAddress().getCountry());
        addressJsonDto.setCity(person.getAddress().getCity());
        addressJsonDto.setStreet(person.getAddress().getCity());
        personJsonDto.setAddressImportDto(addressJsonDto);
        Set<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
        for (PhoneNumber phoneNumber : phoneNumbers) {
            PhoneJsonDto phoneJsonDto = new PhoneJsonDto();
            phoneJsonDto.setNumber(phoneNumber.getNumber());
            phoneJsonDto.setPersonJsonDto(personJsonDto);
            personJsonDto.getPhoneJsonDtos().add(phoneJsonDto);
        }

        return personJsonDto;
    }
}

package app.service;

import app.domain.Country;
import app.repositories.CountryRepository;
import app.service.contracts.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void create(Country country) {
        this.countryRepository.saveAndFlush(country);
    }
}

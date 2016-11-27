package app.service;

import app.domain.Continent;
import app.repositories.ContinentRepository;
import app.service.contracts.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;

public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    @Override
    public void create(Continent continent) {
        this.continentRepository.saveAndFlush(continent);
    }
}

package app.service;

import app.domain.Town;
import app.repositories.TownRepository;
import app.service.contracts.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {

    @Autowired
    private TownRepository townRepository;

    @Override
    public void create(Town town) {
        this.townRepository.saveAndFlush(town);
    }
}

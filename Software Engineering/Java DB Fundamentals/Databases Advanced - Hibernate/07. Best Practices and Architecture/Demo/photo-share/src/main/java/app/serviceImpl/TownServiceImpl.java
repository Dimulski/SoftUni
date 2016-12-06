package app.serviceImpl;

import app.domain.model.Town;
import app.repository.TownRepository;
import app.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TownServiceImpl implements TownService {

    @Autowired
    private TownRepository townRepository;

    public void create(Town town){
        this.townRepository.save(town);
    }
}

package app.service;

import app.domain.Round;
import app.repositories.RoundRepository;
import app.service.contracts.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoundServiceImpl implements RoundService {

    @Autowired
    private RoundRepository roundRepository;

    @Override
    public void create(Round round) {
        this.roundRepository.saveAndFlush(round);
    }
}

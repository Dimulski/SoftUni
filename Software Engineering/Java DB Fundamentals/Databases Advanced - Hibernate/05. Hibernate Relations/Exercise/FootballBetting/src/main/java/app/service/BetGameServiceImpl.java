package app.service;

import app.domain.BetGame;
import app.repositories.BetGameRepository;
import app.service.contracts.BetGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetGameServiceImpl implements BetGameService {

    @Autowired
    private BetGameRepository betGameRepository;

    @Override
    public void create(BetGame betGame) {
        this.betGameRepository.saveAndFlush(betGame);
    }
}

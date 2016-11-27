package app.service;

import app.domain.Bet;
import app.repositories.BetRepository;
import app.service.contracts.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BetServiceImpl implements BetService {

    @Autowired
    private BetRepository betRepository;

    @Override
    public void create(Bet bet) {
        this.betRepository.saveAndFlush(bet);
    }
}

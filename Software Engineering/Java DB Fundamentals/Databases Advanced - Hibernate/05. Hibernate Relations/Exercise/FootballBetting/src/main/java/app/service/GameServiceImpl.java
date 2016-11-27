package app.service;

import app.domain.Game;
import app.repositories.GameRepository;
import app.service.contracts.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public void create(Game game) {
        this.gameRepository.saveAndFlush(game);
    }
}

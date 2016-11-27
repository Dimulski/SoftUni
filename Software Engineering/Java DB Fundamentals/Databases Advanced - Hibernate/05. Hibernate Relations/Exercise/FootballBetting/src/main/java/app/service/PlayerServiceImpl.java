package app.service;

import app.domain.Player;
import app.repositories.PlayerRepository;
import app.service.contracts.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void create(Player player) {
        this.playerRepository.saveAndFlush(player);
    }
}

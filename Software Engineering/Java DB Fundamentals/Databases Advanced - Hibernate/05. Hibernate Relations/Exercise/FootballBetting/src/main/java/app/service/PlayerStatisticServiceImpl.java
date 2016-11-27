package app.service;

import app.domain.PlayerStatistic;
import app.repositories.PlayerStatisticRepository;
import app.service.contracts.PlayerStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatisticServiceImpl implements PlayerStatisticService {

    @Autowired
    private PlayerStatisticRepository playerStatisticRepository;

    @Override
    public void create(PlayerStatistic playerStatistic) {
        this.playerStatisticRepository.saveAndFlush(playerStatistic);
    }
}

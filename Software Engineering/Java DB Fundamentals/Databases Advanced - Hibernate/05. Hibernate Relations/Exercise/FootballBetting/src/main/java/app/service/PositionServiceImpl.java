package app.service;

import app.domain.Position;
import app.repositories.PositionRepository;
import app.service.contracts.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public void create(Position position) {
        this.positionRepository.saveAndFlush(position);
    }
}

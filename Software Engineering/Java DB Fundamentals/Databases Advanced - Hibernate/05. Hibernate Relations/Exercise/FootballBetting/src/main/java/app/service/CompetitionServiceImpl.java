package app.service;

import app.domain.Competition;
import app.repositories.CompetitionRepository;
import app.service.contracts.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionServiceImpl implements CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Override
    public void create(Competition competition) {
        this.competitionRepository.saveAndFlush(competition);
    }
}

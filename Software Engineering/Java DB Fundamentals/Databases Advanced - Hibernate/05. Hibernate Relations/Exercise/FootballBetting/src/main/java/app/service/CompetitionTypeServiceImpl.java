package app.service;

import app.domain.CompetitionType;
import app.repositories.CompetitionTypeRepository;
import app.service.contracts.CompetitionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompetitionTypeServiceImpl implements CompetitionTypeService {

    @Autowired
    private CompetitionTypeRepository competitionTypeRepository;

    @Override
    public void create(CompetitionType competitionType) {
        this.competitionTypeRepository.saveAndFlush(competitionType);
    }
}

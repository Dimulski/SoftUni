package app.service;

import app.domain.Visitation;
import app.repositories.VisitationRepository;
import app.service.contracts.VisitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitationServiceImpl implements VisitationService{

    @Autowired
    private VisitationRepository visitationRepository;

    @Override
    public void create(Visitation visitation) {
        this.visitationRepository.saveAndFlush(visitation);
    }
}

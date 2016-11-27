package app.service;

import app.domain.Team;
import app.repositories.TeamRepository;
import app.service.contracts.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void create(Team team) {
        this.teamRepository.saveAndFlush(team);
    }
}

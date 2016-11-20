package app.service;

import app.domain.Occupancy;
import app.repositories.OccupancyRepository;
import app.service.contracts.OccupancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OccupancyServiceImpl implements OccupancyService {

    @Autowired
    private OccupancyRepository occupancyRepository;

    @Override
    public void create(Occupancy occupancy) {
        this.occupancyRepository.saveAndFlush(occupancy);
    }
}

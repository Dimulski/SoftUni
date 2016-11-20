package app.service;

import app.domain.StoreLocation;
import app.repositories.StoreLocationRepository;
import app.service.contracts.StoreLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreLocationServiceImpl implements StoreLocationService {

    @Autowired
    private StoreLocationRepository storeLocationRepository;

    @Override
    public void create(StoreLocation storeLocation) {
        this.storeLocationRepository.saveAndFlush(storeLocation);
    }
}

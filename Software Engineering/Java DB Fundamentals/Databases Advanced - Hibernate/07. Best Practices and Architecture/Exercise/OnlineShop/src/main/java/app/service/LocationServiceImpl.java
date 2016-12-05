package app.service;

import app.domain.factories.LocationFactory;
import app.domain.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.service.contracts.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationFactory locationFactory;

    @Override
    public Location create() {
        Location location = this.locationFactory.create();
        return location;
    }
}

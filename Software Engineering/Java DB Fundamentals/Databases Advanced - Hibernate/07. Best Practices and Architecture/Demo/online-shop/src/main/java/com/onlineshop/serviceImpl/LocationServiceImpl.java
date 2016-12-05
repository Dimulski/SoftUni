package com.onlineshop.serviceImpl;

import com.onlineshop.domain.factory.LocationFactory;
import com.onlineshop.domain.model.Location;
import com.onlineshop.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationFactory locationFactory;

    @Override
    public Location create(){
        return this.locationFactory.create();
    }
}

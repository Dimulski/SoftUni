package com.social.servicesImpl;

import com.social.entities.Bike;
import com.social.models.viewModels.BikeViewModel;
import com.social.repositories.BikeRepository;
import com.social.services.BikeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BikeViewServiceImpl implements BikeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public BikeViewModel findById(long id) {
        Bike bike = this.bikeRepository.findOne(id);
        BikeViewModel bikeViewModel = this.modelMapper.map(bike, BikeViewModel.class);
        return bikeViewModel;
    }

    @Override
    public List<BikeViewModel> findAll() {
        List<Bike> bikes = this.bikeRepository.findAll();
        List<BikeViewModel> bikeViewModels = new ArrayList();
        for (Bike bike : bikes) {
            BikeViewModel bikeViewModel = this.modelMapper.map(bike, BikeViewModel.class);
            bikeViewModels.add(bikeViewModel);
        }
        return bikeViewModels;
    }
}

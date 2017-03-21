package com.softuni.services;

import com.softuni.entities.Car;
import com.softuni.models.bindingModels.car.CarModel;
import com.softuni.models.viewModels.car.CarView;
import com.softuni.models.viewModels.car.CarWithPartsView;
import com.softuni.repositories.CarRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarView> getAllByMake(String make) {
        List<Car> cars = new ArrayList<>();

        if (make != null) {
            cars = this.carRepository.findByMakeOrderByModelAscTravelledDistanceDesc(make);
        } else {
            cars = this.carRepository.findAllOrderByModelAscTravelledDistanceDesc();
        }

        List<CarView> carViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Car car : cars) {
            CarView carView = modelMapper.map(car, CarView.class);
            carViews.add(carView);
        }

        return carViews;
    }

    @Override
    public CarWithPartsView getById(Long id) {
        Car car = this.carRepository.findOne(id);
        ModelMapper modelMapper = new ModelMapper();
        CarWithPartsView carWithPartsView = null;
        if (car != null) {
            carWithPartsView = modelMapper.map(car, CarWithPartsView.class);
        }

        return carWithPartsView;
    }

    @Override
    public void persist(CarModel carModel) {
        ModelMapper modelMapper = new ModelMapper();
        Car car = modelMapper.map(carModel, Car.class);
        this.carRepository.saveAndFlush(car);
    }
}

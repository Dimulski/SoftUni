package com.softuni.services;

import com.softuni.models.viewModels.car.CarView;
import com.softuni.models.viewModels.car.CarWithPartsView;

import java.util.List;

public interface CarService {

    List<CarView> getAllByMake(String make);
    CarWithPartsView getById(Long id);
}

package com.softuni.services;

import com.softuni.models.bindingModels.car.CarModel;
import com.softuni.models.bindingModels.car.RelatedCarModel;
import com.softuni.models.viewModels.car.CarView;
import com.softuni.models.viewModels.car.CarWithPartsView;

import java.util.List;

public interface CarService {

    List<CarView> getAllByMake(String make);
    CarWithPartsView getById(Long id);
    void persist(CarModel carModel);
    List<CarView> getAll();
    RelatedCarModel getByMake(String carMake);
}

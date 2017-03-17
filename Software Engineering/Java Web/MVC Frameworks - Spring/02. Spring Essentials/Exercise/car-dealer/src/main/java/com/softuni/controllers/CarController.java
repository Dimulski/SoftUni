package com.softuni.controllers;

import com.softuni.models.viewModels.car.CarView;
import com.softuni.models.viewModels.car.CarWithPartsView;
import com.softuni.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("all")
    private String getAllCars(Model model, @RequestParam(value = "make", required = false) String make) {
        List<CarView> carViews = this.carService.getAllByMake(make);
        model.addAttribute("cars", carViews);
        model.addAttribute("view", "/cars/cars-table");

        return "base-layout";
    }

    @GetMapping("{id}/parts")
    private String getCarParts(Model model, @PathVariable Long id) {
        CarWithPartsView car = this.carService.getById(id);
        model.addAttribute("car", car);
        model.addAttribute("view", "/cars/car-parts-table");

        return "base-layout";
    }
}

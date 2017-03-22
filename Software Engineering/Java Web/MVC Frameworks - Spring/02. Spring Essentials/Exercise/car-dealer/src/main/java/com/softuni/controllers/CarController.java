package com.softuni.controllers;

import com.softuni.models.bindingModels.car.CarModel;
import com.softuni.models.bindingModels.part.PartModel;
import com.softuni.models.viewModels.car.CarView;
import com.softuni.models.viewModels.car.CarWithPartsView;
import com.softuni.models.viewModels.part.PartView;
import com.softuni.services.CarService;
import com.softuni.services.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private PartService partService;

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

    @GetMapping("add")
    public String getAddCarPage(Model model) {
        List<PartView> partViews = this.partService.getAll();
        model.addAttribute("parts", partViews);
        model.addAttribute("car", new CarModel());
        model.addAttribute("view", "/cars/cars-add");

        return "base-layout";
    }

    @PostMapping("add")
    public String addCar(@ModelAttribute CarModel carModel, @RequestParam String[] partsNames) {
        Set<PartModel> partModels = new HashSet<>();
        for (String part : partsNames) {
            PartModel partModel = this.partService.getByName(part);
            partModels.add(partModel);
        }
        carModel.setParts(partModels);
        this.carService.persist(carModel);

        return "redirect:/cars/all";
    }
}

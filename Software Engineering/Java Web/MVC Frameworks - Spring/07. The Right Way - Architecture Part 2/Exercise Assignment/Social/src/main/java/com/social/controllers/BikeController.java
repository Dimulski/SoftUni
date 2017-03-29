package com.social.controllers;

import com.social.models.viewModels.BikeViewModel;
import com.social.services.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/bikes")
    public String getBikes(Model model){
        List<BikeViewModel> bikeViewModels = this.bikeService.findAll();
        model.addAttribute("bikes", bikeViewModels);
        return "bikes";
    }

    @GetMapping("/bikes/show/{id}")
    public String showBike(Model model, @PathVariable long id){
        BikeViewModel bikeViewModel = this.bikeService.findById(id);
        model.addAttribute("bike", bikeViewModel);
        return "bike-show";
    }
}

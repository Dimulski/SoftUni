package com.thymeleaflecture.controller;

import com.thymeleaflecture.models.WhiskeyBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class WhiskeyController {

    @GetMapping("/whiskey/add")
    public String getAddWhiskeyPage(@ModelAttribute WhiskeyBindingModel whiskeyBindingModel){
        return "add-whiskey";
    }

    @PostMapping("/whiskey/add")
    public String addWhiskey(@Valid @ModelAttribute WhiskeyBindingModel whiskeyBindingModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            return "add-whiskey";
        }

        return "redirect:/home";
    }
}

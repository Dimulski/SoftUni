package com.springbootlecture.controller;

import com.springbootlecture.entities.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DogController {

    @Autowired
    private Animal dog;

    @GetMapping("/dog")
    @ResponseBody
    public String getHomePage() {
        dog.setName("Sharo");
        return dog.getName();
    }
}

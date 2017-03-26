package com.thymeleaflecture.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getHomePage(Model model) throws ParseException {
        Date myDate = new Date();
        model.addAttribute("myDate", myDate);
        List<Date> dates = new ArrayList(){{
            add(new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-12"));
            add(new SimpleDateFormat("yyyy-MM-dd").parse("2015-03-28"));
        }};
        model.addAttribute("dates", dates);
        String whiskey = "jameson";
        model.addAttribute("whiskey", whiskey);
        float pi = 3.14159f;
        model.addAttribute("pi", pi);
        double[] whiskeyPrice = new double[]{20.50, 30.30, 15.20};
        model.addAttribute("whiskeyPrice", whiskeyPrice);
        String message = "Hi From Controller";
        model.addAttribute("message", message);
        return "home";
    }
}

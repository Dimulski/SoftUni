package controller;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;

import javax.ws.rs.GET;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "redirect:/home/index";
    }

    @GetMapping("/home/index")
    public String index() {
        return "home";
    }

    @GetMapping("/home/about")
    public String boot(){
        return "about";
    }
}

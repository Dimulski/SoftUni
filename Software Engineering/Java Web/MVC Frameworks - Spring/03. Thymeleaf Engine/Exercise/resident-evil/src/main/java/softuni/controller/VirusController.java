package softuni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.models.VirusBindingModel;

@Controller
@RequestMapping("/viruses")
public class VirusController {

    @GetMapping("add")
    public String getAddVirusPage(@ModelAttribute VirusBindingModel virusBindingModel) {
        
        return "add-viruses";
    }
}

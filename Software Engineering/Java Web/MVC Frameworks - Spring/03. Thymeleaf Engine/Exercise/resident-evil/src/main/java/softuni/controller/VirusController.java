package softuni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.entities.enums.Mutation;
import softuni.models.VirusBindingModel;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/viruses")
public class VirusController {

    @ModelAttribute(name = "mutations")
    public List<String> getMutations() {
        List<String> mutationList = new ArrayList<>();
        Mutation[] mutations = Mutation.values();
        for (Mutation mutation : mutations) {
            mutationList.add(mutation.toString());
        }
        
        return mutationList;
    }
    
    @GetMapping("add")
    public String getAddVirusPage(@ModelAttribute VirusBindingModel virusBindingModel) {
        
        return "add-viruses";
    }
    
    @PostMapping("add")
    public String addVirus(@Valid @ModelAttribute VirusBindingModel virusBindingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-viruses";
        }
        
        return "redirect:/";
    }
}

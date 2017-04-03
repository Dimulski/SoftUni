package softuni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.entities.enums.Magnitude;
import softuni.entities.enums.Mutation;
import softuni.models.VirusBindingModel;
import softuni.service.contracts.CapitalService;
import softuni.service.contracts.VirusService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/viruses")
public class VirusController {

    private final CapitalService capitalService;
    
    private final VirusService virusService;
    
    @Autowired
    public VirusController(CapitalService capitalService, VirusService virusService) {
        this.capitalService = capitalService;
        this.virusService = virusService;
    }

    @ModelAttribute(name = "mutations")
    public List<String> getMutations() {
        List<String> mutationList = new ArrayList<>();
        Mutation[] mutations = Mutation.values();
        for (Mutation mutation : mutations) {
            mutationList.add(mutation.toString());
        }
        
        return mutationList;
    }

    @ModelAttribute(name = "magnitudes")
    public List<String> getMagnitude() {
        List<String> magnitudeList = new ArrayList<>();
        Magnitude[] magnitudes = Magnitude.values();
        for (Magnitude magnitude : magnitudes) {
            magnitudeList.add(magnitude.toString());
        }

        return magnitudeList;
    }

    @ModelAttribute(name = "capitalList")
    public List<String> getCapitals() {
        return this.capitalService.getCapitals();
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
        
        this.virusService.create(virusBindingModel);
        
        return "redirect:/";
    }
}

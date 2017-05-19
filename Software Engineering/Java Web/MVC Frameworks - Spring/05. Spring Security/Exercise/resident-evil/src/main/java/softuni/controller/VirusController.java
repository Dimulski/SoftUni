package softuni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import softuni.entities.enums.Magnitude;
import softuni.entities.enums.Mutation;
import softuni.models.bindingModels.AddVirusBindingModel;
import softuni.models.bindingModels.EditVirusBindingModel;
import softuni.models.viewModels.CapitalNameViewModel;
import softuni.models.viewModels.VirusViewModel;
import softuni.service.contracts.CapitalService;
import softuni.service.contracts.VirusService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
public class VirusController {

    private final CapitalService capitalService;
    
    private final VirusService virusService;
    
    @Autowired
    public VirusController(CapitalService capitalService, VirusService virusService) {
        this.capitalService = capitalService;
        this.virusService = virusService;
    }

    @ModelAttribute(name = "mutations")
    public Mutation[] getMutations() {
        return Mutation.values();
    }

    @ModelAttribute(name = "magnitudes")
    public Magnitude[] getMagnitude() {
        return Magnitude.values();
    }

    @ModelAttribute(name = "capitals")
    public Set<CapitalNameViewModel> getCapitalNames() {
        return this.capitalService.getAllCapitals();
    }
    
    @GetMapping("/viruses")
    public String getVirusHomePage(Model model) {
        List<VirusViewModel> viruses = this.virusService.findAllViruses();
        model.addAttribute("viruses", viruses);
        
        return "viruses";
    }
    
    @GetMapping("/viruses/add")
    public String getAddVirusPage(@ModelAttribute AddVirusBindingModel addVirusBindingModel) {
        
        return "viruses-add";
    }
    
    @PostMapping("/viruses/add")
    public String addVirus(@Valid @ModelAttribute AddVirusBindingModel addVirusBindingModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "viruses-add";
        }
        
        this.virusService.save(addVirusBindingModel);
        
        return "redirect:/viruses";
    }
    
    @GetMapping("/viruses/edit/{virusId}")
    public String getEditVirusPage(@PathVariable long virusId, Model model) {
        EditVirusBindingModel editVirusBindingModel = this.virusService.findVirusById(virusId);
        model.addAttribute("editVirusBindingModel", editVirusBindingModel);
        
        return "viruses-edit";
    }

    @PostMapping("/viruses/edit/{virusId}")
    public String getEditVirusPage(@PathVariable long virusId, @Valid @ModelAttribute EditVirusBindingModel editVirusBindingModel, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "viruses-edit";
        }
        
        editVirusBindingModel.setId(virusId);
        this.virusService.save(editVirusBindingModel);
        
        return "redirect:/viruses";
    }

    @GetMapping("/viruses/delete/{virusId}")
    public String deleteVirus(@PathVariable long virusId, Model model) {
        this.virusService.deleteById(virusId);
        
        return "redirect:/viruses";
    }
}

package softuni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.service.contracts.VirusService;

@Controller
@RequestMapping("/map")
public class MapController {

    @Autowired
    private VirusService virusService;
    
    @GetMapping
    public String getMapPage(Model model) {
        String geoJson = this.virusService.findAllMapViruses();
        model.addAttribute("geoJson", geoJson);
        
        return "map";
    }
}

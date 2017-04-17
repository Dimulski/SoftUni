package softuni.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccessController {

    @GetMapping("/noaccess")
    public String getAccessPage() {
        return "No Access";
    }
}

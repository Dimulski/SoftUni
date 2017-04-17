package softuni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import softuni.models.bindingModels.RegisterUserBindingModel;
import softuni.models.viewModels.UserViewModel;
import softuni.service.contracts.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @GetMapping("/register")
    public String getRegisterPage(@ModelAttribute RegisterUserBindingModel registerUserBindingModel) {
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@ModelAttribute RegisterUserBindingModel registerUserBindingModel) {
        this.userService.register(registerUserBindingModel);
        
        return "redirect:/";
    }
    
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
    
    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<UserViewModel> userViewModels = this.userService.findAll();
        model.addAttribute("users", userViewModels);
        
        return "users";
    }
}

package softuni.service.contracts;

import org.springframework.security.core.userdetails.UserDetailsService;
import softuni.models.bindingModels.RegisterUserBindingModel;
import softuni.models.viewModels.UserViewModel;

import java.util.List;

public interface UserService extends UserDetailsService {

    void register(RegisterUserBindingModel registerUserBindingModel);
    
    List<UserViewModel> findAll();
}

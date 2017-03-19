package softuni.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import softuni.models.binding.user.UserRegistrationModel;

public interface StoreUserDetailsService extends UserDetailsService {
    void register(UserRegistrationModel userRegistrationModel);
}

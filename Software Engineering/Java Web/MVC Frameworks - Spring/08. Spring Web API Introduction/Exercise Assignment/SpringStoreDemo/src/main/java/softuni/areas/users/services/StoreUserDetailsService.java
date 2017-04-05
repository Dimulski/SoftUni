package softuni.areas.users.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import softuni.areas.users.models.binding.user.UserRegistrationModel;

public interface StoreUserDetailsService extends UserDetailsService {
    void register(UserRegistrationModel userRegistrationModel);
}

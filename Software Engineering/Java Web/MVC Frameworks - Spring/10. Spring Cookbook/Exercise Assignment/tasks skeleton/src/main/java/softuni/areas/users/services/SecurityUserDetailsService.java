package softuni.areas.users.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import softuni.areas.users.entities.User;
import softuni.areas.users.models.binding.user.UserRegistrationModel;

public interface SecurityUserDetailsService extends UserDetailsService {
    void register(UserRegistrationModel userRegistrationModel);
}

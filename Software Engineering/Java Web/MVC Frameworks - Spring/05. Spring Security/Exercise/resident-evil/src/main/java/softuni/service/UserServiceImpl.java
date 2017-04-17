package softuni.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.entities.User;
import softuni.models.bindingModels.RegisterUserBindingModel;
import softuni.models.viewModels.UserViewModel;
import softuni.repository.UserRepository;
import softuni.service.contracts.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid credentials");
        }
        
        return user;
    }

    @Override
    public void register(RegisterUserBindingModel registerUserBindingModel) {
        User user = this.modelMapper.map(registerUserBindingModel, User.class);
        String normalPassword = user.getPassword();
        String encryptedPassword = this.bCryptPasswordEncoder.encode(normalPassword);
        user.setPassword(encryptedPassword);
        this.userRepository.save(user);
    }

    @Override
    public List<UserViewModel> findAll() {
        List<UserViewModel> userViewModels = new ArrayList<>();
        List<User> users = this.userRepository.findAll();
        for (User user : users) {
            UserViewModel userViewModel = this.modelMapper.map(user, UserViewModel.class);
            userViewModels.add(userViewModel);
        }

        return userViewModels;
    }
}

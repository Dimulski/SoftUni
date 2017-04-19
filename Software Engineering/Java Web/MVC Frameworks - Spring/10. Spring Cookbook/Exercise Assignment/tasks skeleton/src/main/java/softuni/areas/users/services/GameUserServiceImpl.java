package softuni.areas.users.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import softuni.areas.users.entities.User;
import softuni.areas.users.repositories.UserRepository;

@Service
public class GameUserServiceImpl implements GameUserService{

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public GameUserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User getByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid User");
        }

        return user;
    }
}

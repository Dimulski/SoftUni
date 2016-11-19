package app.service;

import app.domain.User;
import app.repositories.UserRepository;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void createUser(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> findUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public int countOfBigPictures(byte[] size) {
        return userRepository.countByProfilePictureGreaterThan(size);
    }
}

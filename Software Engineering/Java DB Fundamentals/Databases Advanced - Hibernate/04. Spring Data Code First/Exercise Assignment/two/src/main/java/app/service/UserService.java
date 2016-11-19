package app.service;

import app.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> findUsersByEmail(String email);

    int countOfBigPictures(byte[] size);
}

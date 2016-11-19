package app.service.contracts;

import app.domain.User;

import java.util.List;

public interface UserService {

    void createUser(User user);

    List<User> findUsersByEmail(String email);

    int countOfBigPictures(byte[] size);
}

package app.service;


import app.domain.model.User;

public interface UserService {

    void create(User user);

    User findByUsername(String username);
}

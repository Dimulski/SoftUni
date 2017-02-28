package com.bookhut.service;

import com.bookhut.entities.User;
import com.bookhut.models.bindingModels.LoginModel;

public interface UserService {

    void createUser(LoginModel loginModel);

    LoginModel findByUsernameAndPassword(String username, String password);
}

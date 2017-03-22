package com.softuni.services;

import com.softuni.models.bindingModels.user.LoggedUser;
import com.softuni.models.bindingModels.user.LoginUser;
import com.softuni.models.bindingModels.user.RegisterUser;

public interface UserService {

    void persist(RegisterUser registerUser);

    LoggedUser getByUsernameAndPassword(String username, String password);

    LoginUser getByUsername(String username);
}

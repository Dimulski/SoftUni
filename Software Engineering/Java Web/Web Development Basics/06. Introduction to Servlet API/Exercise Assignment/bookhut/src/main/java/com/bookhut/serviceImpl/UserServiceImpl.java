package com.bookhut.serviceImpl;

import com.bookhut.entities.User;
import com.bookhut.models.bindingModels.LoginModel;
import com.bookhut.repository.UserRepository;
import com.bookhut.repositoryImpl.UserRepositoryImpl;
import com.bookhut.service.UserService;
import org.modelmapper.ModelMapper;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = UserRepositoryImpl.getInstance();
    }

    @Override
    public void createUser(LoginModel loginModel) {
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(loginModel, User.class);
        this.userRepository.createUser(user);
    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        User user = this.userRepository.findByUsernameAndPassword(username, password);
        ModelMapper modelMapper = new ModelMapper();
        LoginModel loginModel = null;
        if(user != null) {
            loginModel = modelMapper.map(user, LoginModel.class);
        }

        return loginModel;
    }
}

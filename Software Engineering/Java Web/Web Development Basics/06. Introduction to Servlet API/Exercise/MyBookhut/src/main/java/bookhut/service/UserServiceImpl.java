package bookhut.service;

import bookhut.models.bindingModels.LoginModel;
import bookhut.repository.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = UserRepositoryImpl;
    }

    @Override
    public void createUser(LoginModel loginModel) {

    }

    @Override
    public LoginModel findByUsernameAndPassword(String username, String password) {
        return null;
    }
}

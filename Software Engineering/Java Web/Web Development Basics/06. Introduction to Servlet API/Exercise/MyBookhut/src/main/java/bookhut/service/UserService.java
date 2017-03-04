package bookhut.service;

import bookhut.models.bindingModels.LoginModel;

public interface UserService {

    void createUser(LoginModel loginModel);

    LoginModel findByUsernameAndPassword(String username, String password);
}

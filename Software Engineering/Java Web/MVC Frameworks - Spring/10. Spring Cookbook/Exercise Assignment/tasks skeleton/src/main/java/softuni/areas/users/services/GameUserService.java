package softuni.areas.users.services;

import softuni.areas.users.entities.User;


public interface GameUserService {

    User getByEmail(String email);
}

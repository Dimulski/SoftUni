package softuni.services;

import softuni.entities.Role;

public interface RoleService {
    Role findByName(String name);
}

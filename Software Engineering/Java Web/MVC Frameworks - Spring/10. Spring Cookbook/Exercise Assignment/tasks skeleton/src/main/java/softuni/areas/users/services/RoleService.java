package softuni.areas.users.services;

import softuni.areas.users.entities.Role;

public interface RoleService {
    Role findByName(String name);
}

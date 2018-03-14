package javache.repositories;

import java.util.Set;

public interface UserRepository<User> extends Repository<User> {
    User getById(String id);

    void add(User user);

    Set<User> getAll();

    boolean exists(User email);

    User findByEmail(String user);
}

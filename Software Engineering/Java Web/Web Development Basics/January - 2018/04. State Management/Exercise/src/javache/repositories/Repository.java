package javache.repositories;

import java.util.Set;

public interface Repository<T> {
    T getById(String id);

    void add(T object);

    Set<T> getAll();

    boolean exists(T user);
}

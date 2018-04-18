package org.softuni.main.database.repositories;

import org.softuni.main.database.models.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import java.util.List;

public class UserRepository extends BaseRepository {
    public UserRepository(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    private boolean create(String username, String password) {
        this.entityManager.persist(new User(username, password));
        return true;
    }

    private User findById(String userId) {
        User resultingObject = null;

        try {
            resultingObject = (User) this.entityManager
                    .createNativeQuery("SELECT * FROM users as u WHERE u.id = \'" + userId+ "\'", User.class)
                    .getSingleResult();
        } catch(NoResultException e) {
            ;
        }

        return resultingObject;
    }

    private User findByUsername(String username) {
        User resultingObject = null;

        try {
            resultingObject = (User) this.entityManager
                    .createNativeQuery("SELECT * FROM users as u WHERE u.username = \'" + username + "\'", User.class)
                    .getSingleResult();
        } catch(NoResultException e) {
            ;
        }

        return resultingObject;
    }

    private User[] findAll() {
        List<User> resultList = null;

        try {
            resultList = this.entityManager
                    .createNativeQuery("SELECT * FROM users", User.class)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }

        return resultList.toArray(new User[resultList.size()]);
    }

    private void addFriend(String username, String friendName) {
        User user = this.findByUsername(username);
        User friend = this.findByUsername(friendName);

        user.addFriend(friend);
        friend.addFriend(user);
    }
}

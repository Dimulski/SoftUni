package com.pizzamoreLab.repository;

import com.pizzamoreLab.models.user.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserRepository {

    public void createUser(User user){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaMore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public User findByUsernameAndPassword(String username, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pizzaMore");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        User user = null;
        Query query = em.createQuery("SELECT u FROM User AS u " +
                "WHERE u.name = :username " +
                "AND u.password = :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        if(query.getResultList().size() > 0) {
            user = (User) query.getSingleResult();
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
        return user;
    }
}

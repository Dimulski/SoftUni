package problem11FetchUsers;

import connection.Connector;
import core.EntityManager;
import entities.User;

import java.sql.SQLException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "users");
            EntityManager entityManager = new EntityManager(Connector.getConnection());

            Iterable<User> users = entityManager.find(User.class, "YEAR(registration_date) > 2010 AND age >= 18");

            users.forEach(u -> System.out.printf("Username : %s, Password: %s\n", u.getUsername(), u.getPassword()));

        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}

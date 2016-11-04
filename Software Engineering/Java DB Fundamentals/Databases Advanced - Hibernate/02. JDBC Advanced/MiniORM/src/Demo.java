import connection.Connector;
import core.EntityManager;
import entities.User;

import java.sql.Connection;
import java.sql.SQLException;

public class Demo {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException {

        Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "school");
        Connection connection = Connector.getConnection();
        EntityManager entityManager = new EntityManager(connection);

        User user = new User("Pesho", "1234", 20, new java.util.Date());

        entityManager.persist(user);

        System.out.println(entityManager.findFirst(User.class));
    }
}

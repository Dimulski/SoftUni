import connection.Connector;
import core.EntityManager;
import entities.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class Demo {

    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException {

        Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "school");
        Connection connection = Connector.getConnection();
        EntityManager entityManager = new EntityManager(connection);

        User user = new User("Joro", 23, new Date());

        entityManager.persist(user);

        entityManager.findFirst(User.class);
    }
}

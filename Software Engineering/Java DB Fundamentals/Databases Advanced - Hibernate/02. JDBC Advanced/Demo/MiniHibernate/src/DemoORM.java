import connection.DatabaseConnection;
import models.User;
import orm.EntityManager;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by teodo on 20/10/2016.
 */
public class DemoORM {
    public static void main(String[] args) {
        try {
            EntityManager em = new EntityManager(DatabaseConnection.getConnection());
            User student = new User("Ivan2", 23, new Date());
            student.setId(1);
            em.persist(student);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

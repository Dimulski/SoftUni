import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Date;

/**
 * Created by teodo on 24/10/2016.
 */
public class DemoHibernate {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student student = new Student();
        student.setFirstName("John");
        student.setRegistrationDate(new Date());

        session.save(student);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}

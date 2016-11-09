import entities.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("school");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Student john = new Student("John", new Date());

        Student pesho = new Student("Pesho", new Date());

        em.persist(john);
        em.persist(pesho);

        Student findStudent = em.find(Student.class, 1);

//        findStudent.setName("Teo");

//        em.remove(findStudent);
//
//        em.persist(findStudent);
//
//        System.out.println(em.contains(findStudent));

        em.detach(findStudent);

        findStudent.setName("Teo");

        em.merge(findStudent);

        Student studentNew = new Student("Ivan", new Date());
        studentNew.setId(20);

        em.createQuery()

        em.find();
        

        em.persist(studentNew);

        em.merge(studentNew);

        em.getTransaction().commit();
    }
}
import entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department department = new Department();
        department.setName("Trainings");
        Employee employeeManager = em.find(Employee.class,5);
        department.setManager(employeeManager);

        Town town = new Town();
        town.setName("Burgas");

        Address address = new Address();
        address.setAddressText("City Center");
        address.setTown(town);

        Project project = new Project();
        project.setName("Awesome Project");
        project.setDescription("Very Awesome");
        project.setStartDate(new Date());
        project.setEndDate(new Date());

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setMiddleName("A.");
        employee.setLastName("Smith");
        employee.setJobTitle("Master Trainer");
        employee.setSalary(new BigDecimal("10000"));
        employee.setAddress(address);
        employee.setHireDate(new Date());
        employee.setDepartment(department);
        Employee employeeManagerJohn = em.find(Employee.class,1);
        employee.setManager(employeeManagerJohn);
        employee.setProjects(new ArrayList<>());
        employee.getProjects().add(project);

        em.persist(department);
        em.persist(town);
        em.persist(address);
        em.persist(project);
        em.persist(employee);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

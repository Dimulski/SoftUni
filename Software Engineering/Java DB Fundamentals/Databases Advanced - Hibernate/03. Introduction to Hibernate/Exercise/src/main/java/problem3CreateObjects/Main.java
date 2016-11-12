package problem3CreateObjects;

import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Department training = addDepartment(em, "Training");

        Town burgas = addTown(em, "Burgas");

        List<Address> addresses = addAddresses(em, burgas,
                "21 Knjaz Boris I", "91 William Gladstone", "57 Tsarigradska",
                "66 Lyuben Karavelov", "34 Georgi S. Rakovski");

        customAddEmployees(em, training, addresses);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    private static void customAddEmployees(EntityManager em, Department department, List<Address> addresses) {
        String[][] employees = {new String[] {"Victoria", "Doyle", "M", "Marketing Specialist"},
                                new String[] {"Ellen", "Bryant", "C", "Marketing Assistant"},
                                new String[] {"Casey", "Sherman", "F", "Production Technician"},
                                new String[] {"Erick", "Paul", "T", "Production Technician"},
                                new String[] {"Jodi", "Goodwin", "M", "Quality Assurance Technician"}};
        BigDecimal averageSalary = new BigDecimal("18500.0000");

        for (int i = 0; i < employees.length; i++) {
            Employee e = new Employee();
            e.setFirstName(employees[i][0]);
            e.setLastName(employees[i][1]);
            e.setMiddleName(employees[i][2]);
            e.setJobTitle(employees[i][3]);
            e.setDepartment(department);
            e.setManager(em.find(Employee.class, 1));
            e.setHireDate(new Date());
            e.setSalary(averageSalary);
            e.setAddress(addresses.get(i));
            em.persist(e);
        }
    }

    private static List<Address> addAddresses(EntityManager em, Town town, String... addresses) {
        List<Address> addressesResult = new ArrayList<>();
        for (String addressText : addresses) {
            Address address = new Address();
            address.setTown(town);
            address.setAddressText(addressText);
            em.persist(address);
            addressesResult.add(address);
        }
        return addressesResult;
    }

    private static Town addTown(EntityManager em, String townName) {
        Town town = new Town();
        town.setName(townName);
        em.persist(town);
        return town;
    }

    private static Department addDepartment(EntityManager em, String departmentName) {
        Department department = new Department();
        Employee manager = em.find(Employee.class, 1);
        department.setName(departmentName);
        department.setManager(manager);
        em.persist(department);
        return department;
    }
}

import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class CreateObjects {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee manager = (Employee) entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.id = 1 ")
                .getSingleResult();

        Department training = new Department();
        training.setName("Training");
        training.setManager(manager);

        Town burgas = new Town();
        burgas.setName("Burgas");

        Address addressOne = new Address();
        addressOne.setTown(burgas);
        addressOne.setText("Akaciite");

        Address addressTwo = new Address();
        addressTwo.setTown(burgas);
        addressTwo.setText("Rudnik");

        Address addressThree = new Address();
        addressThree.setTown(burgas);
        addressThree.setText("Pobeda");

        Address addressFour = new Address();
        addressFour.setTown(burgas);
        addressFour.setText("Sarafovo");

        Employee ivan = new Employee();
        ivan.setFirstName("Ivan");
        ivan.setMiddleName("Ivanov");
        ivan.setLastName("Ivanov");
        ivan.setJobTitle("Java");
        ivan.setDepartment(training);
        ivan.setAddress(addressOne);
        ivan.setManager(manager);
        ivan.setSalary(new BigDecimal("50000"));
        Date ivanHired = new Date();
        ivan.setHireDate(new Timestamp(ivanHired.getTime()));

        Employee georgi = new Employee();
        georgi.setFirstName("Georgi");
        georgi.setMiddleName("Ivanov");
        georgi.setLastName("Georgiev");
        georgi.setJobTitle("Java Script");
        georgi.setDepartment(training);
        georgi.setAddress(addressTwo);
        georgi.setManager(manager);
        georgi.setSalary(new BigDecimal("40000"));
        Date georgiHired = new Date();
        georgi.setHireDate(new Timestamp(georgiHired.getTime()));

        Employee marin = new Employee();
        marin.setFirstName("Marin");
        marin.setMiddleName("Ivanov");
        marin.setLastName("Georgiev");
        marin.setJobTitle("C#");
        marin.setDepartment(training);
        marin.setAddress(addressThree);
        marin.setManager(manager);
        marin.setSalary(new BigDecimal("40000"));
        Date marinHired = new Date();
        marin.setHireDate(new Timestamp(marinHired.getTime()));

        Employee angel = new Employee();
        angel.setFirstName("Angel");
        angel.setMiddleName("Ivanov");
        angel.setLastName("Angelov");
        angel.setJobTitle("Phyton");
        angel.setDepartment(training);
        angel.setAddress(addressFour);
        angel.setManager(manager);
        angel.setSalary(new BigDecimal("40000"));
        Date angelHired = new Date();
        angel.setHireDate(new Timestamp(angelHired.getTime()));

        Employee venci = new Employee();
        venci.setFirstName("Venci");
        venci.setMiddleName("Ivanov");
        venci.setLastName("Angelov");
        venci.setJobTitle("HTML, CSS");
        venci.setDepartment(training);
        venci.setAddress(addressFour);
        venci.setManager(manager);
        venci.setSalary(new BigDecimal("30000"));
        Date venciHired = new Date();
        venci.setHireDate(new Timestamp(venciHired.getTime()));

        entityManager.getTransaction().begin();

        entityManager.persist(training);
        entityManager.persist(burgas);
        entityManager.persist(addressOne);
        entityManager.persist(addressTwo);
        entityManager.persist(addressThree);
        entityManager.persist(addressFour);
        entityManager.persist(ivan);
        entityManager.persist(georgi);
        entityManager.persist(marin);
        entityManager.persist(angel);
        entityManager.persist(venci);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}

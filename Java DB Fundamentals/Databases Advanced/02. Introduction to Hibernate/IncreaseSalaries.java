import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Write a program that increase salaries of all employees that are in the Engineering, Tool Design,
 * Marketing or Information Services department by 12%. Then print first name, last name and salary
 * for those employees whose salary was increased.
 */

public class IncreaseSalaries {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query employeesSalaries = (Query) entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE department.name IN('Engineering', 'Tool Design', 'Marketing', 'Information Services')");

        List<Employee> employees = employeesSalaries.getResultList();

        entityManager.getTransaction().begin();
        for (Employee employee : employees) {
            employee.setSalary(employee.getSalary()
            .add(employee.getSalary().multiply(BigDecimal.valueOf(0.12))));
            entityManager.persist(employee);
        }

        employees.stream()
                .forEach(e -> System.out.printf("%s %s ($%.2f)\n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getSalary()));

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
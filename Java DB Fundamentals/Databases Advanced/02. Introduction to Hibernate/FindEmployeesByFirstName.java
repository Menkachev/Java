import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

/**
 * Write a program that finds all employees whose first name starts with pattern given as an input from the console.
 * Print their first, last name, their job title and salary in the format given in the examples below.
 */

public class FindEmployeesByFirstName {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Scanner scanner = new Scanner(System.in);

        String pattern = scanner.nextLine();

        Query employeesNames = entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.firstName LIKE :pattern");
        employeesNames.setParameter("pattern", pattern + "%");

        List<Employee> employees = employeesNames.getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s - %s - ($%.2f)\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle(),
                    employee.getSalary());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
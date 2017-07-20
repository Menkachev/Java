import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Find all departments with more than 5 employees. Order them by employee count (ascending).
 * Print the department name, manager name and first name, last name, hire date and job title of every employee.
 */

public class DatabaseSearchQueriesPart4 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Query employeeQuery = entityManager
                .createQuery("SELECT d FROM Department AS d " +
                        "JOIN d.employees AS de " +
                        "GROUP BY d.id " +
                        "HAVING COUNT(de.id) > 5 " +
                        "ORDER BY COUNT(de.id) ASC");

        List<Department> departments = employeeQuery.getResultList();

        System.out.println(departments.size());
        for (Department department : departments) {
            System.out.printf("--%s - Manager: %s, Employees: %d\n",
                    department.getName(),
                    department.getManager().getLastName(),
                    department.getEmployees().size());

            for (Employee employee : department.getEmployees()) {
                System.out.printf("--- First name: %s, Last name: %s, Hire date: %s, Job title: %s\n",
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getHireDate(),
                        employee.getJobTitle());
            }
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
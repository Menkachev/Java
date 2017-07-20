import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Find all employees who have projects started in the time period 2001 - 2003 (inclusive).
 * Print each employee's first name, last name and manager name and each of their projects' name, start date, end date.
 */

public class DatabaseSearchQueriesPart3 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Integer> projectIds = entityManager
                .createQuery("SELECT p.id FROM Project AS p " +
                        "WHERE DATE_FORMAT(p.startDate, '%Y') BETWEEN 2001 AND 2003")
                .getResultList();

        Query employeeQuery = entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "JOIN e.projects AS p " +
                        "WHERE p.id IN (:ids)");

        employeeQuery.setParameter("ids", projectIds);

        List<Employee> employees = employeeQuery.getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s - Manager: %s\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getManager().getFirstName());

            for (Project project : employee.getProjects()) {
                System.out.printf("--- Name: %s  Start date: %s  End date: %s\n",
                        project.getName(),
                        project.getStartDate(),
                        project.getEndDate());
            }
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
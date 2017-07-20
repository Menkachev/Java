import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Get an employee by id (e.g. 147). Print only his/her first name, last name, job title and projects
 * (only their names). The projects should be ordered by name (ascending).
 */

public class DatabaseSearchQueriesPart2 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Project> projectNames = (List<Project>) entityManager
                .createQuery("SELECT p.name FROM Project AS p")
                .getResultList();

        Query employeesQuery = (Query) entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "JOIN e.projects AS p " +
                        "WHERE p.name IN (:names)" +
                        "ORDER BY p.name ASC");

        employeesQuery.setParameter("names", projectNames);

       List<Employee> employees = employeesQuery.getResultList();

        for (Employee employee : employees) {
            System.out.printf("First name: %s, Last name: %s, Job title: %s\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getJobTitle());

            for (Project project : employee.getProjects()) {
                System.out.printf("--- Project name: %s\n",
                        project.getName());
            }
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
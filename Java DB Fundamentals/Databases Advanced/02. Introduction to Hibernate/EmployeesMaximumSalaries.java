import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Comparator;
import java.util.List;

/**
 * Write a program to find the max salary for each department.
 * Filter those which have max salaries not in the range 30000 and 70000.
 */

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query departments = entityManager.createQuery("SELECT d FROM Department AS d " +
                "JOIN Employee AS e ON e.department.id = d.id " +
                "GROUP BY d.id " +
                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000");

        List<Department> departments1 = departments.getResultList();

        departments1.stream()
                .forEach(d -> {
                    d.getEmployees().stream()
                            .sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .limit(1)
                            .forEach(e ->
                                System.out.printf("%s - %.2f\n",
                                        d.getName(),
                                        e.getSalary()));
                            });

        entityManager.close();
        entityManagerFactory.close();
    }
}
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesFromSeattle {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query researchAndDevelopDep = entityManager
                .createQuery("SELECT e FROM Department AS d " +
                        "JOIN Employee AS e ON d.id = e.department.id " +
                        "WHERE d.name = 'Research and Development' " +
                "ORDER BY e.salary ASC, e.firstName DESC ");

        List<Employee> employees = researchAndDevelopDep.getResultList();

        for (Employee employee : employees) {
            System.out.printf("%s %s from %s - $%.2f\n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartment().getName(),
                    employee.getSalary());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmployeesWithSallaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query emmployees = entityManager
                .createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary > 50000");

        List<String> employeesNames = emmployees.getResultList();

        for (String employeesName : employeesNames) {
            System.out.println(employeesName);
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}

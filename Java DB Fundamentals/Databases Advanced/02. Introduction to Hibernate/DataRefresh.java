import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataRefresh {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Employee employeesNames = (Employee) entityManager
                .createQuery("SELECT e FROM Employee AS e WHERE e.id = 4")
                .getSingleResult();

              employeesNames.setFirstName(employeesNames.getFirstName().toUpperCase());
              entityManager.refresh(employeesNames);
              entityManager.persist(employeesNames);

              Employee employeeNameUpdated = (Employee) entityManager
                      .createQuery("SELECT e FROM Employee AS e WHERE e.id = 4")
                      .getSingleResult();
        System.out.printf("%s\n", employeeNameUpdated.getFirstName());

        entityManager.close();
        entityManagerFactory.close();
    }
}
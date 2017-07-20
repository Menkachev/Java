import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String employeeName = scanner.nextLine();

         try {
             Employee employee = (Employee)
                     entityManager
                     .createQuery("SELECT e FROM Employee AS e WHERE CONCAT(e.firstName, ' ', e.lastName) = "
                             + String.format("'%s'", employeeName))
                     .getSingleResult();
             System.out.println("Yes");
         } catch (NoResultException ex){
            System.out.println("No");
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
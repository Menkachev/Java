import entities.Address;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Write a program that deletes town which name is given as an input. Also delete all addresses that are in those towns.
 * Print on the console the number addresses that were deleted.
 */

public class RemoveTowns {
    public static void main(String[] args) throws IOException {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String townName = reader.readLine();
        Query addressQuery = entityManager
                .createQuery("SELECT a FROM Address AS a WHERE a.town.name = :townName");
        addressQuery.setParameter("townName", townName);

        List<Address> addresses = addressQuery.getResultList();

        entityManager.getTransaction().begin();
        Town town = null;
        for (Address address : addresses) {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            entityManager.flush();
            entityManager.remove(address);
        }
        
       entityManager.remove(town);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}

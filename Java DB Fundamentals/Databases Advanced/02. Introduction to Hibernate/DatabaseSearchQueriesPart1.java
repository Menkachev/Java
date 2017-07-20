import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Find all addresses, ordered by the number of employees who live there (descending), then by town name (ascending).
 * Take only the first 10 addresses and print their address text, town name and employee count.
 */

public class DatabaseSearchQueriesPart1 {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address AS a " +
                "ORDER BY a.employees.size DESC, a.town.name ASC")
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.printf("%s %s - %d employees\n",
                    address.getText(),
                    address.getTown().getName(),
                    address.getEmployees().size());
        }
    }
}
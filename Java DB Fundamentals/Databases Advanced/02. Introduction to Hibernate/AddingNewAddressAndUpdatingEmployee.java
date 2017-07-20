import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);

        Query lastName = entityManager.createQuery("SELECT e FROM Employee AS e WHERE e.lastName = 'Nakov'");
        Employee employee = (Employee) lastName.getSingleResult();
        employee.setAddress(address);
        entityManager.persist(address);
        entityManager.getTransaction().commit();

        System.out.println(employee.getAddress().getText());

        entityManager.close();
        entityManagerFactory.close();
    }
}

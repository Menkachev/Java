import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Write a program that prints last 10 started projects.
 * Print their name, description, start and end date and sort them by name lexicographically.
 */

public class FindLatest10Projects {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory =
                Persistence
                        .createEntityManagerFactory("PersistenceUnit");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query projects = entityManager
                .createQuery("SELECT p FROM Project AS p " +
                        "ORDER BY p.startDate DESC")
                .setMaxResults(10);

        List<Project> lastProjects = projects.getResultList();

        for (Project lastProject : lastProjects) {
            System.out.printf("Name: %s, Description: %s, Start date: %s, End date: %s\n",
                    lastProject.getName(),
                    lastProject.getDescription(),
                    lastProject.getStartDate(),
                    lastProject.getEndDate());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
package org.example;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.modelos.Cliente;
import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentes");

        EntityManager em = emf.createEntityManager();

        return em;
    }
    public static void main(String[] args) {

        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente1 = new Cliente("Sabrina","1234567");
            em.persist(cliente1);
            // Aca irian las acciones

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

    }
}



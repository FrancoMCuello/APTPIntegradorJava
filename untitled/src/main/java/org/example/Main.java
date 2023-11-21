package org.example;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");

        EntityManager em = emf.createEntityManager();

        return em;
    }
    public static void main(String[] args) {

        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            // Aca irian las acciones

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {

        }
    }
}



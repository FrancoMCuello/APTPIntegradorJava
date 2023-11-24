package org.example.service;

import org.example.modelos.Incidente;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

import static org.example.Main.getEntityManager;

public class IncidenteService {

    static EntityManager em = getEntityManager();

    public static List<Incidente> obtenerTodosLosIncidentes() {

        try {
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT i FROM Incidente i", Incidente.class);
            List<Incidente> incidentes = query.getResultList();

            em.getTransaction().commit();

            return incidentes;
        } finally {

        }
    }
}

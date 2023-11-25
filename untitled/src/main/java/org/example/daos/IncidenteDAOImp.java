package org.example.daos;

import org.example.modelos.Incidente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class IncidenteDAOImp implements IncidenteDAO {
    private EntityManager em;
    @Override
    public void agregarIncidente(Incidente incidente) {
        em.persist(incidente);

    }

    @Override
    public void modificarIncidente(Incidente incidente) {

        em.merge(incidente);
    }

    @Override
    public void eliminarIncidente(Long id) {

        Incidente incidente = em.find(Incidente.class, id);

        // Verificar si el incidente existe antes de intentar eliminarlo
        if (incidente != null) {
            em.remove(incidente);
        } else {
            // Manejar la situación en la que el incidente no fue encontrado
            System.out.println("Incidente con ID " + id + " no encontrado.");
        }

    }

    @Override
    public Incidente obtenerIncidente(Long id) {
      return em.find(Incidente.class, id);
// Si find devuelve null, podrías lanzar una excepción o manejar la situación según tus requisitos.
    }


    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}

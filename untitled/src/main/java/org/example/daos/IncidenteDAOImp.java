package org.example.daos;

import org.example.modelos.Incidente;
import org.example.modelos.Tecnico;

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
    public void eliminarIncidente(Incidente incidente) {
        Incidente i = em.merge(incidente);
        em.remove(i);
    }

    @Override
    public Incidente obtenerIncidente(int id) {
        return em.find(Incidente.class, id);
// Si find devuelve null, podrías lanzar una excepción o manejar la situación según tus requisitos.
    }

    @Override
    public List<Incidente> obtenerTodosLosIncidentes() {

        return em.createQuery("SELECT t FROM Tecnico t", Incidente.class).getResultList();
    }


    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

}

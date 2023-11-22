package org.example.daos;

import org.example.modelos.Incidente;

import javax.persistence.EntityManager;
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
    public Incidente buscarIncidente(int id) {
      return em.find(Incidente.class, id);

    }
    @Override
    public List<Incidente> obtenerTodosLosIncidentes() {
        return null;
    }
}
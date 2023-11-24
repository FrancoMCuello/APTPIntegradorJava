package org.example.daos;

import org.example.modelos.Tecnico;

import javax.persistence.EntityManager;
import java.util.List;

public class TecnicoDAOImp implements TecnicoDAO{
    private EntityManager em;
    @Override
    public void agregarTecnico(Tecnico tecnico) {
        em.persist(tecnico);
    }

    @Override
    public void actualizarTecnico(Tecnico tecnico) {
        em.merge(tecnico);

    }

    @Override
    public void eliminarTecnico(Tecnico tecnico) {
        Tecnico t = em.merge(tecnico);
        em.remove(t);

    }

    @Override
    public Tecnico buscarTecnico(int id) {

        return em.find(Tecnico.class, id);
    }

    @Override
    public List<Tecnico> obtenerTodosLosTecnicos() {

        return em.createQuery("SELECT t FROM Tecnico t", Tecnico.class).getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}

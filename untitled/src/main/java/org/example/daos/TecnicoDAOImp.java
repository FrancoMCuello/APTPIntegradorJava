package org.example.daos;

import org.example.modelos.Incidente;
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
    public void eliminarTecnico(Long id) {
        Tecnico tecnico = em.find(Tecnico.class, id);

        // Verificar si el incidente existe antes de intentar eliminarlo
        if (tecnico != null) {
            em.remove(tecnico);
        } else {
            // Manejar la situación en la que el incidente no fue encontrado
            System.out.println("Tecnico con ID " + id + " no encontrado.");
        }

    }

    @Override
    public Tecnico buscarTecnico(Long id) {

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
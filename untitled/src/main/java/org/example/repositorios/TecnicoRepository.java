package org.example.repositorios;

import org.example.daos.TecnicoDAO;
import org.example.factory.DAOFactory;
import org.example.modelos.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TecnicoRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");
    private TecnicoDAO tecnicoDAO;

    public TecnicoRepository(){
        this.tecnicoDAO = DAOFactory.getTecnicoDAO();
    }

    private EntityManager obtenerEntityManagerConfigurado() {

        EntityManager em = emf.createEntityManager();

        tecnicoDAO.setEntityManager(em);

        return em;
    }

    public void add (Tecnico tecnico) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        tecnicoDAO.agregarTecnico(tecnico);

        em.getTransaction().commit();
        em.close();

    }

    public void remove(Long id) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        tecnicoDAO.eliminarTecnico(id);

        em.getTransaction().commit();
        em.close();
    }

    public Tecnico get(Long id) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        Tecnico tecnico = tecnicoDAO.buscarTecnico(id);

        em.getTransaction().commit();
        em.close();
        return tecnico;
    }

    public void update(Tecnico tecnico) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        tecnicoDAO.actualizarTecnico(tecnico);

        em.getTransaction().commit();
        em.close();
    }

}
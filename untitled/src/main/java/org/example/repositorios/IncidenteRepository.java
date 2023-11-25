package org.example.repositorios;

import org.example.daos.IncidenteDAO;
import org.example.factory.DAOFactory;
import org.example.modelos.Incidente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IncidenteRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");
    private IncidenteDAO incidenteDAO;

    public IncidenteRepository(){
        this.incidenteDAO = DAOFactory.getIncidenteDAO();
    }

    private EntityManager obtenerEntityManagerConfigurado() {

        EntityManager em = emf.createEntityManager();

        incidenteDAO.setEntityManager(em);

        return em;
    }

    public void add(Incidente incidente) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        incidenteDAO.agregarIncidente(incidente);

        em.getTransaction().commit();
        em.close();

    }

    public void remove(Long id) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        incidenteDAO.eliminarIncidente(id);

        em.getTransaction().commit();
        em.close();
    }

    public Incidente get(Long id) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        Incidente incidente = incidenteDAO.obtenerIncidente(id);

        em.getTransaction().commit();
        em.close();
        return incidente;
    }

    public void update(Incidente incidente) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        incidenteDAO.modificarIncidente(incidente);

        em.getTransaction().commit();
        em.close();
    }

}
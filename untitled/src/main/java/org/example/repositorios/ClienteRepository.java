package org.example.repositorios;

import org.example.daos.ClienteDAO;
import org.example.factory.DAOFactory;
import org.example.modelos.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");
    private ClienteDAO clienteDAO;

    public ClienteRepository(){
        this.clienteDAO = DAOFactory.getClienteDAO();
    }

    private EntityManager obtenerEntityManagerConfigurado() {

        EntityManager em = emf.createEntityManager();

        clienteDAO.setEntityManager(em);

        return em;
    }

    public void add(Cliente cliente) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        clienteDAO.agregarCliente(cliente);

        em.getTransaction().commit();
        em.close();

    }

    public void remove(Long id) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        clienteDAO.eliminarCliente(id);

        em.getTransaction().commit();
        em.close();
    }

    public Cliente get(Long id) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        Cliente cliente = clienteDAO.buscarCliente(id);

        em.getTransaction().commit();
        em.close();
        return cliente;
    }

    public void update(Cliente cliente) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        clienteDAO.modificarCliente(cliente);

        em.getTransaction().commit();
        em.close();
    }

}

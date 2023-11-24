package org.example.daos;

import org.example.modelos.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public class ClienteDAOImp implements ClienteDAO {

    private EntityManager em;
    @Override
    public void agregarCliente(Cliente cliente) {
         em.persist(cliente);
    }

    @Override
    public void modificarCliente(Cliente cliente) {
           em.merge(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        Cliente c = em.merge(cliente);
        em.remove(c);
    }

    @Override
    public Cliente buscarCliente(Long id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> obtenerTodosLosCliente() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}

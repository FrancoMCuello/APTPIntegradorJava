package org.example.daos;

import org.example.modelos.Cliente;
import org.example.modelos.Incidente;

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
    public void eliminarCliente(Long id) {
        Cliente cliente = em.find(Cliente.class, id);

        // Verificar si el incidente existe antes de intentar eliminarlo
        if (cliente != null) {
            em.remove(cliente);
        } else {
            // Manejar la situación en la que el incidente no fue encontrado
            System.out.println("Cliente con ID " + id + " no encontrado.");
        }
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

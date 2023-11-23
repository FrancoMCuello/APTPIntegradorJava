package org.example.daos;

import org.example.modelos.Cliente;

import javax.persistence.EntityManager;
import java.util.List;

public interface ClienteDAO {
    public void agregarCliente(Cliente cliente);

    public void modificarCliente(Cliente cliente);

    public void eliminarCliente(Cliente cliente);

    public Cliente buscarCliente(Integer id);

    public List<Cliente> obtenerTodosLosCliente();

    public void setEntityManager(EntityManager em);

}


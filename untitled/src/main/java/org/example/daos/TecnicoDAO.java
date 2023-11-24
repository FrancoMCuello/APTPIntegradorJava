package org.example.daos;

import org.example.modelos.Tecnico;

import javax.persistence.EntityManager;
import java.util.List;

public interface TecnicoDAO {

    public void agregarTecnico(Tecnico tecnico);

    public void actualizarTecnico(Tecnico tecnico);

    public void eliminarTecnico(Tecnico tecnico);

    public Tecnico buscarTecnico(int id);

    public List<Tecnico> obtenerTodosLosTecnicos();

    public void setEntityManager(EntityManager em);
}

package org.example.daos;

import org.example.modelos.Incidente;
import org.example.modelos.Tecnico;


import javax.persistence.EntityManager;
import java.util.List;

public interface IncidenteDAO {

    public void agregarIncidente(Incidente incidente);

    public void modificarIncidente(Incidente incidente);

    public void eliminarIncidente(Incidente incidente);

    public Incidente obtenerIncidente(int id);

    public List<Incidente> obtenerTodosLosIncidentes();

    public void setEntityManager(EntityManager em);
}

package org.example.daos;

import org.example.modelos.Incidente;


import javax.persistence.EntityManager;
import java.util.List;

public interface IncidenteDAO {

    public void agregarIncidente(Incidente incidente);

    public void modificarIncidente(Incidente incidente);

    public void eliminarIncidente(Long id);

    public Incidente obtenerIncidente(Long id);

    public void setEntityManager(EntityManager em);

}

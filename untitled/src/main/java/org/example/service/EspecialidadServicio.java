package org.example.service;

import org.example.modelos.Especialidad;
import org.example.modelos.Incidente;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

import static org.example.Main.getEntityManager;

public class EspecialidadServicio {
    static EntityManager em = getEntityManager();

    public static Especialidad obtenerEspecialidadPorID(Long idEspecialidad) {

            try {
                em.getTransaction().begin();
                return em.find(Especialidad.class, idEspecialidad);
            } finally {
                em.getTransaction().commit();
                em.close();
            }

    }
}


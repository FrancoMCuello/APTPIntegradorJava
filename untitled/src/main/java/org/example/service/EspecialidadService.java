package org.example.service;

import org.example.modelos.Especialidad;

import javax.persistence.EntityManager;

import static org.example.Main.getEntityManager;

public class EspecialidadService {
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


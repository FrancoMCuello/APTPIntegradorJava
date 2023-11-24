package org.example.service;

import org.example.daos.TecnicoDAO;
import org.example.factory.DAOFactory;
import org.example.modelos.Tecnico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TecnicoRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-tecnico-unit");
    private TecnicoDAO tecnicoDAO;

    public TecnicoRepository(){

        this.tecnicoDAO = DAOFactory.geTecnicoDAO();
    }

    private EntityManager obtenerEntityManagerConfigurado() {

        EntityManager em = emf.createEntityManager();

        tecnicoDAO.setEntityManager(em);

        return em;
    }

    public void add (Tecnico tecnico) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        em.getTransaction().begin();

        tecnicoDAO.agregarTecnico(tecnico);

        em.getTransaction().commit();
        em.close();

    }

    public void remove(Tecnico tecnico) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        // comienza la transaccion
        em.getTransaction().begin();

        tecnicoDAO.eliminarTecnico(tecnico);
        // finalizar la transaccion
        em.getTransaction().commit();
        em.close();
    }

    public Tecnico get(Integer id) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        // comienza la transaccion
        em.getTransaction().begin();

        // forzar la cargar de los comentarios antes de salir de la capa de servicio

        Tecnico tecnico = tecnicoDAO.buscarTecnico(id);
        //publicacion.setComentarios(comentarios);
        /**List<Tecnico> listTecnicosGral = TecnicoDAO.obtenerLista();
         listTecnicosGral.stream().forEach(t -> );
         Publicacion publicacion = publicacionDAO.read(id);
         publicacion.setComentarios(comentarios);**/

        // finalizar la transaccion
        em.getTransaction().commit();
        em.close();
        return tecnico;
    }

    public void update(Tecnico tecnico) throws Exception {
        EntityManager em = obtenerEntityManagerConfigurado();

        // comienza la transaccion
        em.getTransaction().begin();

        // no se está usando cascade, por eso requerido
        //publicacion.getComentarios().stream().forEach(c -> comentarioDAO.update(c));
        tecnicoDAO.actualizarTecnico(tecnico);
        //publicacionDAO.update(publicacion);
        // finalizar la transaccion
        em.getTransaction().commit();
        em.close();
    }


}

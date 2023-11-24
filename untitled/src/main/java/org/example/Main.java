package org.example;
import org.example.daos.ClienteDAOImp;
import org.example.daos.IncidenteDAOImp;
import org.example.daos.TecnicoDAOImp;
import org.example.modelos.*;
import org.example.modelos.Tecnico;
import org.example.service.TecnicoService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {


    public static void main(String[] args) {


        // Configuración de la base de datos
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");
        EntityManager em = emf.createEntityManager();

        // Creación de instancias de DAOs y Services
        ClienteDAOImp clienteDAO = new ClienteDAOImp();
        clienteDAO.setEntityManager(em);

        TecnicoDAOImp tecnicoDAO = new TecnicoDAOImp();
        tecnicoDAO.setEntityManager(em);

        IncidenteDAOImp incidenteDAO = new IncidenteDAOImp();
        incidenteDAO.setEntityManager(em);

        TecnicoService tecnicoService = new TecnicoService(incidenteDAO);

        // Crear instancias de entidades
        Especialidad especialidad1 = new Especialidad("Redes");
        Especialidad especialidad2 = new Especialidad("Software");

        Tecnico tecnico1 = new Tecnico("Juan", "Perez", Arrays.asList(especialidad1), "123-456");
        Tecnico tecnico2 = new Tecnico("Maria", "Lopez", Arrays.asList(especialidad2), "789-012");

        Cliente cliente1 = new Cliente("Empresa A", "123456", Arrays.asList());
        Cliente cliente2 = new Cliente("Empresa B", "789012", Arrays.asList());

        Servicio servicio1 = new Servicio("Windows");
        Servicio servicio2 = new Servicio("Linux");

        TipoProblema tipoProblema1 = new TipoProblema("Red");
        TipoProblema tipoProblema2 = new TipoProblema("Software");
        Incidente incidente1 = new Incidente(Arrays.asList(), "Problema de red", Incidente.Estado.RESUELTO, cliente1, tecnico1, LocalDate.now());
        Incidente incidente2 = new Incidente(Arrays.asList(), "Problema de software", Incidente.Estado.RESUELTO, cliente2, tecnico2, LocalDate.now());
        Incidente incidente3 = new Incidente(Arrays.asList(), "Problema de software", Incidente.Estado.RESUELTO, cliente1, tecnico2, LocalDate.now());

        // Persistir las entidades
        em.getTransaction().begin();

        em.persist(especialidad1);
        em.persist(especialidad2);

        em.persist(tecnico1);
        em.persist(tecnico2);

        em.persist(cliente1);
        em.persist(cliente2);

        em.persist(servicio1);
        em.persist(servicio2);

        em.persist(incidente1);
        em.persist(incidente2);

        em.getTransaction().commit();

        Tecnico tecnicoServiceTecnicoConMasIncidentesResueltosEnUltimosNDias = tecnicoService.getTecnicoConMasIncidentesResueltosEnUltimosNDias(1);

        Tecnico tecnicoConMasIncidentesPorEspecialidad = tecnicoService.getTecnicoConMasIncidentesResueltosEnEspecialidadYUltimosNDias(especialidad1, 1);

        Tecnico tecnicoConResolucionMasRapida = tecnicoService.getTecnicoConResolucionMasRapida();

        System.out.println("tecnico con mas incidentes por especialidad es: " + tecnicoConMasIncidentesPorEspecialidad.getNombre());
        System.out.println("tecnico con mas incidentes resueltos en los ultimos días es: " + tecnicoServiceTecnicoConMasIncidentesResueltosEnUltimosNDias.getNombre());
        System.out.println("tecnico con resolucion de incidentes más rapida: " + tecnicoConResolucionMasRapida.getNombre());


        // Cierre de recursos
        em.close();
        emf.close();


    }


    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");

        EntityManager em = emf.createEntityManager();

        return em;
    }
}

//        // CODIGO PARA PROBAR LA CONEXION A LA BD
//        // Configuración de la conexión
//        String url = "jdbc:mysql://localhost:3306/gestion_incidentes";
//        String usuario = "root";
//        String contraseña = "admin";
//
//        try {
//            // Carga del controlador JDBC
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Intento de conexión a la base de datos
//            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
//
//            // Verificación de la conexión exitosa
//            if (connection != null) {
//                System.out.println("Conexión exitosa a la base de datos");
//                // Puedes realizar más operaciones con la conexión aquí
//                // ...
//
//                // Cierre de la conexión cuando hayas terminado
//                connection.close();
//            } else {
//                System.out.println("No se pudo establecer la conexión a la base de datos");
//            }
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            // Manejar la excepción
//        }





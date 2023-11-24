package org.example;

import org.example.daos.ClienteDAOImp;
import org.example.daos.IncidenteDAOImp;
import org.example.daos.TecnicoDAOImp;
import org.example.modelos.*;
import org.example.service.EspecialidadServicio;
import org.example.service.TecnicoService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.example.service.EspecialidadServicio.obtenerEspecialidadPorID;
import static org.example.service.IncidenteService.obtenerTodosLosIncidentes;


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

//        // Crear instancias de entidades
//        Especialidad especialidad1 = new Especialidad("Redes");
//        Especialidad especialidad2 = new Especialidad("Software");
//
//        Tecnico tecnico1 = new Tecnico("Juan", "Perez", Arrays.asList(especialidad1), "123-456");
//        Tecnico tecnico2 = new Tecnico("Maria", "Lopez", Arrays.asList(especialidad2), "789-012");
//
//        Cliente cliente1 = new Cliente("Empresa A", "123456", Arrays.asList());
//        Cliente cliente2 = new Cliente("Empresa B", "789012", Arrays.asList());
//
//        Servicio servicio1 = new Servicio("Windows");
//        Servicio servicio2 = new Servicio("Linux");
//
//        TipoProblema tipoProblema1 = new TipoProblema("Red");
//        TipoProblema tipoProblema2 = new TipoProblema("Software");
//
//        LocalDate fechaInicio1 = LocalDate.of(2023, 11, 20);
//        LocalDate fechaInicio2 = LocalDate.of(2023, 11, 22);
//        LocalDate fechaInicio3 = LocalDate.of(2023, 11, 17);
//
//        Incidente incidente1 = new Incidente(Arrays.asList(tipoProblema1), "Problema de red", Incidente.Estado.RESUELTO, fechaInicio1, LocalDate.now(), cliente1, tecnico1);
//        Incidente incidente2 = new Incidente(Arrays.asList(tipoProblema2), "Problema de software", Incidente.Estado.RESUELTO, fechaInicio2, LocalDate.now(), cliente2, tecnico2);
//        Incidente incidente3 = new Incidente(Arrays.asList(tipoProblema2), "Problema de software", Incidente.Estado.RESUELTO, fechaInicio3, LocalDate.now(), cliente1, tecnico2);
//
//        // Persistir las entidades
//        em.getTransaction().begin();
//
//        em.persist(especialidad1);
//        em.persist(especialidad2);
//
//        em.persist(tecnico1);
//        em.persist(tecnico2);
//
//        em.persist(cliente1);
//        em.persist(cliente2);
//
//        em.persist(servicio1);
//        em.persist(servicio2);
//
//        em.persist(incidente1);
//        em.persist(incidente2);
//        em.persist(incidente3);

//        em.getTransaction().commit();

        // Cierre de recursos
        em.close();
        emf.close();

        Tecnico tecnicoServiceTecnicoConMasIncidentesResueltosEnUltimosNDias = tecnicoService.getTecnicoConMasIncidentesResueltosEnUltimosNDias(5);

        Tecnico tecnicoConMasIncidentesPorEspecialidad = tecnicoService.getTecnicoConMasIncidentesResueltosEnEspecialidadYUltimosNDias(1L, 10);

        Tecnico tecnicoConResolucionMasRapida = tecnicoService.getTecnicoConResolucionMasRapida();

        System.out.println(tecnicoConMasIncidentesPorEspecialidad.getNombre());
        System.out.println(tecnicoServiceTecnicoConMasIncidentesResueltosEnUltimosNDias.getNombre());
        System.out.println(tecnicoConResolucionMasRapida.getNombre());

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

//    }



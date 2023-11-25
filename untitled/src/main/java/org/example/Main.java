package org.example;

import org.example.daos.ClienteDAOImp;
import org.example.daos.IncidenteDAOImp;
import org.example.daos.TecnicoDAOImp;
import org.example.modelos.*;
import org.example.repositorios.ClienteRepository;
import org.example.repositorios.IncidenteRepository;
import org.example.repositorios.TecnicoRepository;
import org.example.service.EspecialidadService;
import org.example.service.IncidenteService;
import org.example.service.RRHHService;
import org.example.service.TecnicoService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {

        Logger hibernateLogger = Logger.getLogger("org.hibernate");
        hibernateLogger.setLevel(Level.OFF);

        // También puedes desactivar los manejadores de consola si no deseas ningún mensaje
        for (Handler handler : hibernateLogger.getHandlers()) {
            if (handler instanceof ConsoleHandler) {
                hibernateLogger.removeHandler(handler);
            }
        }
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

        IncidenteRepository incidenteRepository = new IncidenteRepository();

        TecnicoRepository tecnicoRepository = new TecnicoRepository();

        ClienteRepository clienteRepository = new ClienteRepository();

        TecnicoService tecnicoService = new TecnicoService(incidenteDAO);

        IncidenteService incidenteService = new IncidenteService();

        EspecialidadService especialidadService = new EspecialidadService();

        RRHHService RRHHService = new RRHHService(incidenteService, tecnicoDAO);



        // Crear instancias de entidades
        Especialidad especialidad1 = new Especialidad("Redes");
        Especialidad especialidad2 = new Especialidad("Software");

        Tecnico tecnico1 = new Tecnico("Juan", "Perez", List.of(especialidad1), "123-456");
        Tecnico tecnico2 = new Tecnico("Maria", "Lopez", List.of(especialidad2), "789-012");

        Servicio servicio1 = new Servicio("Windows");
        Servicio servicio2 = new Servicio("Linux");

        Cliente cliente1 = new Cliente("Empresa A", "123456", List.of(servicio1, servicio2));
        Cliente cliente2 = new Cliente("Empresa B", "789012", List.of(servicio2));

        TipoProblema tipoProblema1 = new TipoProblema("Red");
        TipoProblema tipoProblema2 = new TipoProblema("Software");

        LocalDate fechaInicio1 = LocalDate.of(2023, 11, 20);
        LocalDate fechaInicio2 = LocalDate.of(2023, 11, 22);
        LocalDate fechaInicio3 = LocalDate.of(2023, 11, 17);

        Incidente incidente1 = new Incidente(List.of(tipoProblema1), "Problema de red", Incidente.Estado.RESUELTO, fechaInicio1, LocalDate.now(), cliente1, tecnico1);
        Incidente incidente2 = new Incidente(List.of(tipoProblema2), "Problema de software", Incidente.Estado.RESUELTO, fechaInicio2, LocalDate.now(), cliente2, tecnico2);
        Incidente incidente3 = new Incidente(List.of(tipoProblema2), "Problema de software", Incidente.Estado.RESUELTO, fechaInicio3, LocalDate.now(), cliente1, tecnico2);

        // Persistir las entidades manual

        em.getTransaction().begin();

        em.persist(especialidad1);
        em.persist(especialidad2);

        em.persist(servicio1);
        em.persist(servicio2);

        em.persist(tipoProblema1);
        em.persist(tipoProblema2);

        em.getTransaction().commit();

        //Metodo crear persistencias con los repos

        tecnicoRepository.add(tecnico1);
        tecnicoRepository.add(tecnico2);
        clienteRepository.add(cliente1);
        clienteRepository.add(cliente2);
        incidenteRepository.add(incidente1);
        incidenteRepository.add(incidente2);
        incidenteRepository.add(incidente3);

        //Elimina la persistencias
        incidenteRepository.remove(2L);

        RRHHService.generarReporteDiario();

        // Cierre de recursos
        em.close();
        emf.close();

        Tecnico tecnicoServiceTecnicoConMasIncidentesResueltosEnUltimosNDias = tecnicoService.getTecnicoConMasIncidentesResueltosEnUltimosNDias(5);

        Tecnico tecnicoConMasIncidentesPorEspecialidad = tecnicoService.getTecnicoConMasIncidentesResueltosEnEspecialidadYUltimosNDias(1L, 10);

        Tecnico tecnicoConResolucionMasRapida = tecnicoService.getTecnicoConResolucionMasRapida();

        System.out.println("tecnico con mas incidentes por especialidad: " + tecnicoConMasIncidentesPorEspecialidad.getNombre());
        System.out.println("tecnico con mas incidentes resueltos los ultimos días: " + tecnicoServiceTecnicoConMasIncidentesResueltosEnUltimosNDias.getNombre());
        System.out.println("tecnico con resolucion mas rapida: " + tecnicoConResolucionMasRapida.getNombre());

    }

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");

        EntityManager em = emf.createEntityManager();

        return em;
    }



   /** private static void crearIncidente(Incidente incidente) throws Exception {
        // utilizo las capas de servicio de manera transparente
        // Creo una publicacion
        IncidenteRepository incidenteRepository = new IncidenteRepository();
        Incidente i1 = new Incidente();

        incidenteRepository.add(i1);

        System.out.println("Id del incidente creado es:" +i1.getId());

    }
    private static void crearCliente(ClienteRepository clienteRepository) throws Exception {
        // utilizo las capas de servicio de manera transparente
        // Creo una publicacion
        Cliente c1 = new Cliente();


        clienteRepository.add(c1);

        System.out.println("Id del cliente creado es:" +c1.getId());

    } **/
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



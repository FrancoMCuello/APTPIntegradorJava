package org.example;
import org.example.modelos.Especialidad;
import org.example.modelos.Incidente;
import org.example.modelos.Tecnico;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.example.modelos.Cliente;
import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");

        EntityManager em = emf.createEntityManager();

        return em;
    }
    public static void main(String[] args) {

        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            Cliente cliente1 = new Cliente(1L,"Sabrina","1234567");

            Especialidad especialidad1 = new Especialidad(1L, "especialidad1");
            em.persist(especialidad1);
            Especialidad especialidad2 = new Especialidad(2L, "especialidad2");
            em.persist(especialidad2);
            List<Especialidad> especialidadesTecnico1 = new ArrayList<>();
            especialidadesTecnico1.add(especialidad1);
            especialidadesTecnico1.add(especialidad2);

            Tecnico tecnico1 = new Tecnico(1L, "Carlos", "Gutierrez", especialidadesTecnico1, "MAIL");
            em.persist(tecnico1);

            Incidente incidente = new Incidente(1L, "no anda el wifi", "no se puede conectar al wifi", Incidente.Estado.PENDIENTE, cliente1, tecnico1);
            em.persist(incidente);

            cliente1.setIncidentes(List.of(incidente));
            em.persist(cliente1);
            // Aca irian las acciones

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
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

    }
}



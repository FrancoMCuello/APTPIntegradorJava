package org.example;
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

public class Main {

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionIncidentesPU");

        EntityManager em = emf.createEntityManager();

        return em;
    }
    public static void main(String[] args) {
try {
        EntityManager em = getEntityManager();} catch ( Exception e) {e.printStackTrace();}

//        try {
//            em.getTransaction().begin();
//
////            Cliente cliente1 = new Cliente(1L,"Sabrina","1234567");
////            em.persist(cliente1);
//            // Aca irian las acciones
//
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // CODIGO PARA PROBAR LA CONEXION A LA BD
        // Configuración de la conexión
        String url = "jdbc:mysql://localhost:3306/gestion_incidentes";
        String usuario = "root";
        String contraseña = "admin";

        try {
            // Carga del controlador JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Intento de conexión a la base de datos
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);

            // Verificación de la conexión exitosa
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos");
                // Puedes realizar más operaciones con la conexión aquí
                // ...

                // Cierre de la conexión cuando hayas terminado
                connection.close();
            } else {
                System.out.println("No se pudo establecer la conexión a la base de datos");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Manejar la excepción
        }

    }
}



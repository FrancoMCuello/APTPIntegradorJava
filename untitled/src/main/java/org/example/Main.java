package org.example;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.integrador.hibernateConfig.HibernateConfig;

public class App {
    public static void main(String[] args) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Aca irian las acciones

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
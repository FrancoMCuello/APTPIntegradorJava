package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        try (Session session = org.integrador.hibernateConfig.HibernateConfig.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            // Aca irian las acciones

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    }

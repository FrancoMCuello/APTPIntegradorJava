package org.example.factory;

import org.example.daos.*;

public class DAOFactory {

    public static ClienteDAO getClienteDAO() {
        try {
            return new ClienteDAOImp();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static TecnicoDAO getTecnicoDAO() {
        try {
            return new TecnicoDAOImp();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static IncidenteDAO getIncidenteDAO() {
        try {
            return new IncidenteDAOImp();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

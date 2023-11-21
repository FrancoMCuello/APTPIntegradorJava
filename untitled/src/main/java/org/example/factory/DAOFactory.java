package org.example.factory;

import org.example.daos.*;

public class DAOFactory {

    public static ClienteDAO geClienteDAO() {
        return new ClienteDAOImp();
    }
    public static TecnicoDAO geTecnicoDAO() {
        return new TecnicoDAOImp();
    }
    public static IncidenteDAO geIncidenteDAO() {
        return new IncidenteDAOImp();
    }

}

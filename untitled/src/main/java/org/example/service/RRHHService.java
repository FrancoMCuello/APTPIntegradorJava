package org.example.service;

import org.example.daos.TecnicoDAO;
import org.example.modelos.Incidente;
import org.example.modelos.Tecnico;

import java.util.List;

public class RRHHService {

    private final TecnicoDAO tecnicoDAO;
    private final IncidenteService incidenteService;
    public List<Tecnico> obtenerTodosLosTecnicos() {
        return tecnicoDAO.obtenerTodosLosTecnicos();
    }

    public RRHHService(IncidenteService incidenteService, TecnicoDAO tecnicoDAO) {
        this.incidenteService = incidenteService;
        this.tecnicoDAO = tecnicoDAO;
    }

    public List<Incidente> obtenerIncidentesPorTecnico(Tecnico tecnico) {
        return incidenteService.obtenerIncidentesPorTecnico(tecnico);
    }

    public void generarReporteDiario() {
        List<Tecnico> tecnicos = obtenerTodosLosTecnicos();

        for (Tecnico tecnico : tecnicos) {
            List<Incidente> incidentes = obtenerIncidentesPorTecnico(tecnico);

            System.out.println("Informe Diario para " + tecnico.getNombre());
            for (Incidente incidente : incidentes) {
                System.out.println("Incidente #" + incidente.getId() +
                        " - Estado: " + incidente.getEstadoIncidente());
            }
            System.out.println("--------------------------------------");
        }
    }
}

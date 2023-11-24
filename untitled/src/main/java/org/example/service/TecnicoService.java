package org.example.service;

import org.example.daos.IncidenteDAOImp;
import org.example.modelos.Especialidad;
import org.example.modelos.Incidente;
import org.example.modelos.Tecnico;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static org.example.service.IncidenteService.obtenerTodosLosIncidentes;
import static org.example.service.EspecialidadServicio.obtenerEspecialidadPorID;

public class TecnicoService {

        private final IncidenteDAOImp incidenteDAO;

        public TecnicoService(IncidenteDAOImp incidenteDAO) {
            this.incidenteDAO = incidenteDAO;
        }


        public Tecnico getTecnicoConMasIncidentesResueltosEnUltimosNDias(int nDias) {

            List<Incidente> incidentes = obtenerTodosLosIncidentes();

            List<Incidente> incidentesResueltosEnUltimosNDias = incidentes.stream()
                    .filter(incidente -> incidente.getEstadoIncidente() == Incidente.Estado.RESUELTO &&
                            incidente.getFechaResolucion().isAfter(LocalDate.now().minusDays(nDias)))
                    .toList();

            Map<Tecnico, Long> conteoPorTecnico = incidentesResueltosEnUltimosNDias.stream()
                    .collect(Collectors.groupingBy(Incidente::getTecnicoAsignado, Collectors.counting()));

            return conteoPorTecnico.entrySet().stream()
                    .max(Comparator.comparing(Map.Entry::getValue))
                    .map(Map.Entry::getKey)
                    .orElse(null);
        }

    public Tecnico getTecnicoConMasIncidentesResueltosEnEspecialidadYUltimosNDias(Long idespecialidad, int nDias) {
            Especialidad especialidad = obtenerEspecialidadPorID(idespecialidad);
        List<Incidente> incidentesResueltosEnUltimosNDias = obtenerTodosLosIncidentes().stream()
                .filter(incidente -> incidente.getEstadoIncidente() == Incidente.Estado.RESUELTO &&
                        incidente.getFechaResolucion().isAfter(LocalDate.now().minusDays(nDias)) &&
                        incidente.getTecnicoAsignado().getEspecialidades().stream()
                                .anyMatch(e -> e.equals(especialidad)))
                .toList();

        Map<Tecnico, Long> conteoPorTecnico = incidentesResueltosEnUltimosNDias.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnicoAsignado, Collectors.counting()));

        return conteoPorTecnico.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Tecnico getTecnicoConResolucionMasRapida() {
        List<Incidente> incidentesResueltos = obtenerTodosLosIncidentes().stream()
                .filter(incidente -> incidente.getEstadoIncidente() == Incidente.Estado.RESUELTO &&
                        incidente.getFechaInicio() != null && incidente.getFechaResolucion() != null)
                .toList();

        Map<Tecnico, Double> tiempoPromedioPorTecnico = incidentesResueltos.stream()
                .collect(Collectors.groupingBy(Incidente::getTecnicoAsignado,
                        Collectors.averagingDouble(incidente ->
                                ChronoUnit.DAYS.between(incidente.getFechaInicio(), incidente.getFechaResolucion()))
                ));

        Optional<Map.Entry<Tecnico, Double>> tecnicoConResolucionMasRapida = tiempoPromedioPorTecnico.entrySet().stream()
                .min(Comparator.comparing(Map.Entry::getValue));

        return tecnicoConResolucionMasRapida.map(Map.Entry::getKey).orElse(null);
    }

}

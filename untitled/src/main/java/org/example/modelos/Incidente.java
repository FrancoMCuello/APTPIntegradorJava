package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @ManyToMany(mappedBy = "incidentes")
    private List<TipoProblema> tipoProblema;

    private String descripcion;

    private LocalDate tiempoResolucion;
    public enum Estado {
        PENDIENTE,
        RESUELTO
    }
    private Estado estadoIncidente;

    private boolean esComplejo;

    private int colchonHoras;

    private LocalDate fechaInicio;

    private LocalDate fechaResolucion;

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnicoAsignado;

    public Incidente( List<TipoProblema> tipoProblema, String descripcion, org.example.modelos.Incidente.Estado estadoIncidente, Cliente cliente, Tecnico tecnicoAsignado, LocalDate fechaInicio) {
        this.tipoProblema = tipoProblema;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.estadoIncidente = estadoIncidente;
        this.cliente = cliente;
        this.tecnicoAsignado = tecnicoAsignado;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipoProblema(List<TipoProblema> tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public LocalDate getTiempoResolucion() {
        return tiempoResolucion;
    }

    public void setTiempoResolucion(LocalDate tiempoResolucion) {
        this.tiempoResolucion = tiempoResolucion;
    }

    public Estado getEstadoIncidente() {
        return estadoIncidente;
    }

    public void setEstadoIncidente(org.example.modelos.Incidente.Estado estadoIncidente) {
        this.estadoIncidente = estadoIncidente;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {

        this.tecnicoAsignado = tecnicoAsignado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
}

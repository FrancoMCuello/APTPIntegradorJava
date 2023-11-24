package org.example.modelos;

import lombok.Getter;
import net.bytebuddy.asm.Advice;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Incidente() {
    }

    @ManyToMany(mappedBy = "incidentes")
    private List<TipoProblema> tipoProblema;

    private String descripcion;

    private LocalDate tiempoResolucion;

    public Long getId() {
        return id;
    }

    public enum Estado {
        PENDIENTE,
        RESUELTO
    }

    private Estado estadoIncidente;

    private boolean esComplejo;

    private int colchonHoras;


    private LocalDate fechaInicio;

    public Estado getEstadoIncidente() {
        return estadoIncidente;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    public Tecnico getTecnicoAsignado() {
        return tecnicoAsignado;
    }

    private LocalDate fechaResolucion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Getter
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

    public Incidente(List<TipoProblema> tipoProblema, String descripcion, Estado estadoIncidente, LocalDate fechaInicio, LocalDate fechaResolucion, Cliente cliente, Tecnico tecnicoAsignado) {
        this.tipoProblema = tipoProblema;
        this.descripcion = descripcion;
        this.estadoIncidente = estadoIncidente;
        this.fechaInicio = fechaInicio;
        this.fechaResolucion = fechaResolucion;
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

    public void setEstadoIncidente(org.example.modelos.Incidente.Estado estadoIncidente) {
        this.estadoIncidente = estadoIncidente;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTecnicoAsignado(Tecnico tecnicoAsignado) {

        this.tecnicoAsignado = tecnicoAsignado;
    }

}

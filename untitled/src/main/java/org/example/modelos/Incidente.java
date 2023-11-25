package org.example.modelos;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "incidente_tipoProblema",
            joinColumns = @JoinColumn(name = "incidente_id"),
            inverseJoinColumns = @JoinColumn(name = "tipoProblema_id"))
    private List<TipoProblema> tipoProblema;

    private LocalDate fechaInicio;

    private String descripcion;

    private LocalDate tiempoResolucion;

    private Estado estadoIncidente;

    private boolean esComplejo;

    private int colchonHoras;

    private LocalDate fechaResolucion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnicoAsignado;
    public enum Estado {
        PENDIENTE,
        RESUELTO
    }
    public Incidente() {
    }

    public Incidente(List<TipoProblema> tipoProblema, LocalDate fechaInicio, String descripcion, Estado estadoIncidente, Cliente cliente, Tecnico tecnicoAsignado) {
        this.tipoProblema = tipoProblema;
        this.fechaInicio = fechaInicio;
        this.descripcion = descripcion;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TipoProblema> getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(List<TipoProblema> tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public void setEstadoIncidente(Estado estadoIncidente) {
        this.estadoIncidente = estadoIncidente;
    }

    public boolean isEsComplejo() {
        return esComplejo;
    }

    public void setEsComplejo(boolean esComplejo) {
        this.esComplejo = esComplejo;
    }

    public int getColchonHoras() {
        return colchonHoras;
    }

    public void setColchonHoras(int colchonHoras) {
        this.colchonHoras = colchonHoras;
    }

    public LocalDate getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(LocalDate fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
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
}

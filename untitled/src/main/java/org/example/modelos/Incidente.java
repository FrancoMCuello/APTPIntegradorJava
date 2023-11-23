package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
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

    private Date tiempoResolucion;

    private Date fechaInicio;

    public Long getId() {
        return id;
    }

    public List<TipoProblema> getTipoProblema() {
        return tipoProblema;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(Date fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
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

    private Date fechaResolucion;

    public enum Estado {
        PENDIENTE,
        RESUELTO
    }
    private Estado estadoIncidente;

    private boolean esComplejo;

    private int colchonHoras;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnicoAsignado;

    public Incidente( List<TipoProblema> tipoProblema, String descripcion, org.example.modelos.Incidente.Estado estadoIncidente, Cliente cliente, Tecnico tecnicoAsignado) {
        this.tipoProblema = tipoProblema;
        this.descripcion = descripcion;
        //this.tiempoResolucion = tiempoResolucion;
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

    public Date getTiempoResolucion() {
        return tiempoResolucion;
    }

    public void setTiempoResolucion(Date tiempoResolucion) {
        this.tiempoResolucion = tiempoResolucion;
    }

    public org.example.modelos.Incidente.Estado getEstadoIncidente() {
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
    
}

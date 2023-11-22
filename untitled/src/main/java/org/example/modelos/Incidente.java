package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Entity
@Table
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoProblema;

    private String descripcion;

    private Date tiempoResolucion;
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

    public Incidente(Long id, String tipoProblema, String descripcion, org.example.modelos.Incidente.Estado estadoIncidente, Cliente cliente, Tecnico tecnicoAsignado) {
        this.id = id;
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

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    @ManyToOne
    @JoinColumn(name = "operador_id")
    private Operador operador;
}

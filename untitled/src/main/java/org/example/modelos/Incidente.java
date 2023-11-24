package org.example.modelos;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
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

}

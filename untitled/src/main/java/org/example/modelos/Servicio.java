package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Servicio() {
    }

    private String nombre;

    private String descripcion;

    @ManyToMany(mappedBy = "servicios")
    private List<Cliente> clientes;

    public Long getId() {
        return id;
    }

    public Servicio(String nombre) {
        this.nombre = nombre;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

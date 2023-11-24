package org.example.modelos;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razonSocial;

    private String cuit;

    @ManyToMany
    @JoinTable(
            name = "cliente_servicios",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> servicios;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;

    public Cliente(){}

    public Cliente(String razonSocial, String cuit, List<Servicio> servicios) {
        this.razonSocial = razonSocial;
        this.servicios = servicios;
        this.cuit = cuit;
    }
}


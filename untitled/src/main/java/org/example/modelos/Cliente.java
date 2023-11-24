package org.example.modelos;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Cliente {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String razonSocial;

    @Getter
    @Setter
    private String cuit;

    @Getter
    @Setter
    @ManyToMany
    @JoinTable(
            name = "cliente_servicios",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id"))
    private List<Servicio> servicios;

    @Getter
    @Setter
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;

    public Cliente(){}
    public Cliente(String razonSocial, String cuit, List<Servicio> servicios) {
        this.razonSocial = razonSocial;
        this.servicios = servicios;
        this.cuit = cuit;
    }
}


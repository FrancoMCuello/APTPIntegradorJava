package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
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

    public List<Servicio> getServicio() {
        return servicios;
    }

    public void setServicio(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    public Cliente(String razonSocial, String cuit, List<Servicio> servicios) {
        this.razonSocial = razonSocial;
        this.servicios = servicios;
        this.cuit = cuit;
    }

    public Cliente(String razonSocial, String cuit) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

    public Cliente(Long id, String razonSocial, String cuit, List<Incidente> incidentes) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.incidentes = incidentes;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;
}


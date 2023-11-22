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

    public Cliente( String razonSocial, String cuit) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

    public Cliente(Long id, String razonSocial, String cuit, List<Incidente> incidentes) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
        this.incidentes = incidentes;
    }

    private String cuit;

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

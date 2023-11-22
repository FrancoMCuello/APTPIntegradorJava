package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String razonSocial;

    public Cliente( String razonSocial, String cuit) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

    private String cuit;

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

package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoProblema;

    public TipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    public TipoProblema() {
    }

    @Getter
    @ManyToMany(mappedBy = "tipoProblema")
    private List<Incidente> incidentes;

    public TipoProblema(String tipoProblema, Date tiempoEstimado, Date tiempoMaximo) {
        this.tipoProblema = tipoProblema;
        this.tiempoEstimado = tiempoEstimado;
        this.tiempoMaximo = tiempoMaximo;
    }

    private Date tiempoEstimado;

    private Date tiempoMaximo;

}

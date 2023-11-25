package org.example.modelos;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class TipoProblema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoProblema;

    private Date tiempoEstimado;

    private Date tiempoMaximo;

    @ManyToMany(mappedBy = "tipoProblema")
    private List<Incidente> incidentes;

    public TipoProblema() {
    }

    public TipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public TipoProblema(String tipoProblema, Date tiempoEstimado, Date tiempoMaximo) {
        this.tipoProblema = tipoProblema;
        this.tiempoEstimado = tiempoEstimado;
        this.tiempoMaximo = tiempoMaximo;
    }

}

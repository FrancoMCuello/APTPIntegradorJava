package org.example.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Operador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "operador", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;
}

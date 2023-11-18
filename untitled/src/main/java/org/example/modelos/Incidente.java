package org.example.modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Incidente {
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

   // @ManyToOne
   // @JoinColumn(name = "cliente_id")
    private Cliente cliente;

  //  @ManyToOne
   // @JoinColumn(name = "tecnico_id")
    private Tecnico tecnicoAsignado;

   // @ManyToOne
   // @JoinColumn(name = "operador_id")
    private Operador operador;
}

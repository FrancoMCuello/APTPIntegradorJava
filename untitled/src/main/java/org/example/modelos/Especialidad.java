package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Table
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    @ManyToMany(mappedBy = "especialidades")
    private List<Tecnico> tecnicos;
}

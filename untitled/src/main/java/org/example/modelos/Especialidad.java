package org.example.modelos;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Especialidad {
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    public Especialidad(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    @ManyToMany(mappedBy = "especialidades")

    private List<Tecnico> tecnicos;
}

package org.example.modelos;

import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
public class Operador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String apellido;

    public Integer getId() {
        return id;
    }

    public Operador(String nombre, String apellido) {

        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    @OneToMany(mappedBy = "operador", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;
}

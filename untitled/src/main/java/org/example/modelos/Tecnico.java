package org.example.modelos;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String contacto;

    @ManyToMany
    @JoinTable(
            name = "tecnico_especialidad",
            joinColumns = @JoinColumn(name = "tecnico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "tecnicoAsignado", cascade = CascadeType.ALL)
    private List<Incidente> incidentesAsignados;

    public Tecnico() {
    }

    public Tecnico(String nombre, String apellido, List<Especialidad> especialidades, String contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidades = especialidades;
        this.contacto = contacto;
    }

    public Tecnico(String nombre, String apellido, String contacto, List<Especialidad> especialidades, List<Incidente> incidentesAsignados) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contacto = contacto;
        this.especialidades = especialidades;
        this.incidentesAsignados = incidentesAsignados;
    }


}

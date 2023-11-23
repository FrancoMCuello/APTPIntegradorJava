package org.example.modelos;

import lombok.Getter;
import org.example.modelos.Especialidad;
import org.example.modelos.Incidente;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    private String contacto;

    @ManyToMany
    @JoinTable(
    name = "tecnico_especialidad",
    joinColumns = @JoinColumn(name = "tecnico_id"),
    inverseJoinColumns = @JoinColumn(name = "especialidad_id"))
    private List<Especialidad> especialidades;

    @OneToMany(mappedBy = "tecnicoAsignado", cascade = CascadeType.ALL)
    private List<Incidente> incidentesAsignados;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public List<Incidente> getIncidentesAsignados() {
        return incidentesAsignados;
    }

    public void setIncidentesAsignados(List<Incidente> incidentesAsignados) {
        this.incidentesAsignados = incidentesAsignados;
    }

    public Tecnico( String nombre, String apellido, List<Especialidad> especialidades, String contacto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.especialidades = especialidades;
        this.contacto = contacto;
    }

}

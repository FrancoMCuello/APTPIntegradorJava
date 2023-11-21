package org.example.daos;

import org.example.modelos.Tecnico;

import java.util.List;

public interface TecnicoDAO {

    public void agregarTecnico(Tecnico tecnico);

    public void actualizarTecnico(Long id);

    public void eliminarTecnico(Long id);

    public void buscarTecnico(Long id);

    public List<Tecnico> obtenerTodosLosTecnicos();

}

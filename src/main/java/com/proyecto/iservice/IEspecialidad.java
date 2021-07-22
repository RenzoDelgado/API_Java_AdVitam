package com.proyecto.iservice;

import java.util.List;
import java.util.Optional;

import com.proyecto.modelo.Especialidad;



public interface IEspecialidad {

	public List<Especialidad> listarEspecilidad();
	public int agregarEspecialidad(Especialidad espe);
	public int actualizarEspecialidad(Especialidad espe);
	public Optional<Especialidad> buscarporid(int id);
}

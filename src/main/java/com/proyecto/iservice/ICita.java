package com.proyecto.iservice;

import java.util.List;

import com.proyecto.modelo.Cita;

public interface ICita {

	public List<Cita> listarCita();
	public int agregarCita (Cita ci);
	public int actualizarCita (Cita ci);
	public List<Cita> traercita(int id, String fecha);
}

package com.proyecto.iservice;

import java.util.List;

import com.proyecto.modelo.Doctor;

public interface IDoctor {

	public List<Doctor> listraDoctor();

	public Doctor buscarDoctor(int id);
	
	public int agregarDoctor(Doctor doc);
	
	public int actualizarDoctor(Doctor doc);
	
	public List<Doctor> doctoresxespecialidad(int id);
}

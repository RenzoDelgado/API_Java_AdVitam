package com.proyecto.iservice;

import java.util.List;

import com.proyecto.modelo.Horario;

public interface IHorario {

	public List<Horario> listarHorario();
	
	public int agregarHorario(Horario ho) ;
		
	public List<Horario> horarioxdoctor(int id);
	
}

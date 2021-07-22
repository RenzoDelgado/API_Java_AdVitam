package com.proyecto.iservice;

import java.util.List;

import com.proyecto.modelo.PrecioConsulta;

public interface IPrecioConsulta {

	public List<PrecioConsulta> listarPrecioConsulta();
	
	public List<PrecioConsulta> precioxidespe(int id);
	
	public int agregarPrecioConsulta(PrecioConsulta prec);
	
	public int actualizarPrecioConsulta(PrecioConsulta prec);
	
}

package com.proyecto.iservice;

import java.util.List;

import com.proyecto.modelo.Aseguradora;

public interface IAseguradora {

	public List<Aseguradora> listarAseguradora();
	
	public int AgragarAseguradora(Aseguradora ase);
	public int ActualizarAseguradora(Aseguradora ase);
}

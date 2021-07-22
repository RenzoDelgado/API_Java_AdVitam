package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.AseguradoraDAO;
import com.proyecto.iservice.IAseguradora;
import com.proyecto.modelo.Aseguradora;

@Service
public class AseguradoraService implements IAseguradora {

	@Autowired
	private AseguradoraDAO dao;
	
	
	@Override
	public List<Aseguradora> listarAseguradora() {
		// TODO Auto-generated method stub
		return (List<Aseguradora>) dao.findAll();
	}

	@Override
	public int AgragarAseguradora(Aseguradora ase) {
		if(ase == null) {
			return 0;
		}
		dao.save(ase);
		return 1;
	}

	@Override
	public int ActualizarAseguradora(Aseguradora ase) {
		if(ase == null) {
			return 0;
		}
		dao.save(ase);
		return 1;
	}

}

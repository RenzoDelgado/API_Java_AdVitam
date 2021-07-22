package com.proyecto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.EspecialidadDAO;
import com.proyecto.iservice.IEspecialidad;
import com.proyecto.modelo.Especialidad;

@Service
public class EspecialidadService implements IEspecialidad{

	@Autowired
	private EspecialidadDAO dao;
	
	@Override
	public List<Especialidad> listarEspecilidad() {
		// TODO Auto-generated method stub
		return (List<Especialidad>) dao.findAll();
	}

	@Override
	public int agregarEspecialidad(Especialidad espe) {
		if(espe == null) {
			return 0;
		}
		dao.save(espe);
		return 1;
	}

	@Override
	public int actualizarEspecialidad(Especialidad espe) {
		if(espe == null) {
			return 0;
		}
		dao.save(espe);
		return 1;
	}

	@Override
	public Optional<Especialidad> buscarporid(int id) {
		return dao.findById(id);
	}

	

}

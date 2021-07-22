package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.CitaDAO;
import com.proyecto.iservice.ICita;
import com.proyecto.modelo.Cita;

@Service
public class CitaService implements ICita{

	@Autowired
	private CitaDAO dao;
	
	@Override
	public List<Cita> listarCita() {
		
		return (List<Cita>) dao.findAll();
	}

	@Override
	public int agregarCita(Cita ci) {
		if(ci == null) {
			return 0;
		}
		dao.save(ci);
		return 1;
	}

	@Override
	public int actualizarCita(Cita ci) {
		if(ci == null) {
			return 0;
		}
		dao.save(ci);
		return 1;
	}

	@Override
	public List<Cita> traercita(int id, String fecha) {
		return dao.traercitas(id, fecha);
	}

}

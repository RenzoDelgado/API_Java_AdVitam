package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.PrecioConsultaDAO;
import com.proyecto.iservice.IPrecioConsulta;
import com.proyecto.modelo.PrecioConsulta;

@Service
public class PrecioConsultaService implements IPrecioConsulta{

	@Autowired
	private PrecioConsultaDAO dao;
	
	@Override
	public List<PrecioConsulta> listarPrecioConsulta() {
		// TODO Auto-generated method stub
		return (List<PrecioConsulta>) dao.findAll();
	}

	@Override
	public int agregarPrecioConsulta(PrecioConsulta prec) {
		if(prec == null) {
			return 0;
		}
		dao.save(prec);
		return 1;
	}

	@Override
	public int actualizarPrecioConsulta(PrecioConsulta prec) {
		if(prec == null) {
			return 0;
		}
		dao.save(prec);
		return 1;
	}

	@Override
	public List<PrecioConsulta> precioxidespe(int id) {
		return dao.precioxespecialidad(id);
	}

}

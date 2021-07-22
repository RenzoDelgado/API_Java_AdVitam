package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.HorarioDAO;
import com.proyecto.iservice.IHorario;
import com.proyecto.modelo.Horario;

@Service
public class HorarioService implements IHorario {

	@Autowired
	private HorarioDAO dao;
	
	@Override
	public List<Horario> listarHorario() {
		
		return (List<Horario>) dao.findAll();
	}

	@Override
	public int agregarHorario(Horario ho) {
		if(ho == null) {
			return 0;
		}
		dao.save(ho);
		return 1;
	}

	@Override
	public List<Horario> horarioxdoctor(int id) {
		return dao.horarioxdoctor(id);
	}

}

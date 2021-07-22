package com.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.DoctorDAO;
import com.proyecto.iservice.IDoctor;
import com.proyecto.modelo.Doctor;

@Service
public class DoctorService  implements IDoctor{

	@Autowired
	private DoctorDAO dao;
	
	@Override
	public List<Doctor> listraDoctor() {
		// TODO Auto-generated method stub
		return (List<Doctor>) dao.findAll();
	}

	@Override
	public int agregarDoctor(Doctor doc) {
		if(doc == null) {
			return 0;
		}
		dao.save(doc);
		return 1;
	}

	@Override
	public int actualizarDoctor(Doctor doc) {
		if(doc == null) {
			return 0;
		}
		dao.save(doc);
		return 1;
	}

	@Override
	public Doctor buscarDoctor(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public List<Doctor> doctoresxespecialidad(int id) {
		return dao.doctorxespecialidad(id);
	}

	

	

}

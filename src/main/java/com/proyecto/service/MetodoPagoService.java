package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.MetodoPagoDAO;
import com.proyecto.iservice.IMetodoPago;
import com.proyecto.modelo.Metodopago;

@Service
public class MetodoPagoService implements IMetodoPago {

	@Autowired
	private MetodoPagoDAO dao;
	
	@Override
	public List<Metodopago> ListarMetodoPago() {
		
		return (List<Metodopago>) dao.findAll();
	}

	@Override
	public int AgregarMetodoPago(Metodopago metoP) {
		if(metoP ==null) {
			return 0;
		}
		dao.save(metoP);
		return 1;
	}

	

}

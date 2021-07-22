package com.proyecto.iservice;

import java.util.List;

import com.proyecto.modelo.Metodopago;

public interface IMetodoPago {

	public List<Metodopago> ListarMetodoPago();
	public int AgregarMetodoPago(Metodopago metoP);
	
}

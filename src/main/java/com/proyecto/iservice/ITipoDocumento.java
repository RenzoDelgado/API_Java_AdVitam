package com.proyecto.iservice;

import java.util.List;

import com.proyecto.modelo.TipoDocumento;

public interface ITipoDocumento {

	public List<TipoDocumento> listarTipoDocumento();
	
	public int agregarTipoDocumento(TipoDocumento tipoD);
}

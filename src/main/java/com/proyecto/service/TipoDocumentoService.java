package com.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.dao.TipoDocumentoDAO;
import com.proyecto.iservice.ITipoDocumento;
import com.proyecto.modelo.TipoDocumento;

@Service
public class TipoDocumentoService implements ITipoDocumento {

	@Autowired
	private TipoDocumentoDAO dao;
	
	@Override
	public List<TipoDocumento> listarTipoDocumento() {
		// TODO Auto-generated method stub
		return (List<TipoDocumento>) dao.findAll();
	}

	@Override
	public int agregarTipoDocumento(TipoDocumento tipoD) {
		if(tipoD == null) {
			return 0;
		}
		dao.save(tipoD);
		return 1;
	}

}

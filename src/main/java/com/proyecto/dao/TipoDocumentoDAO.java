package com.proyecto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.modelo.TipoDocumento;

public interface TipoDocumentoDAO extends JpaRepository<TipoDocumento,Integer> {

}

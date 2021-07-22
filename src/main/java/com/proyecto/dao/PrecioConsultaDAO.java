package com.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.proyecto.modelo.PrecioConsulta;

public interface PrecioConsultaDAO extends JpaRepository<PrecioConsulta, Integer> {

	@Query(value="SELECT * from tb_precioconsulta p where p.idEspecialidad =  :id ",nativeQuery=true)
	List<PrecioConsulta> precioxespecialidad(@Param("id") int id);
}

package com.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.modelo.Cita;

public interface CitaDAO extends JpaRepository<Cita, Integer>{
	
	@Query(value="SELECT * FROM tb_cita WHERE idDoctor = :iddoctor AND fecha = :fecha AND estado=1", nativeQuery=true)
	List<Cita> traercitas(@Param("iddoctor") int id,@Param("fecha") String fecha);
	
}

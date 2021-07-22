package com.proyecto.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.modelo.Horario;

public interface HorarioDAO extends JpaRepository<Horario, Integer> {
	
	@Query(value="SELECT * FROM tb_horario WHERE idDoctor = :id AND estado=1 AND fecha >= NOW() ORDER BY fecha ASC",nativeQuery=true)
	List<Horario> horarioxdoctor(@Param("id")int id);
	
}

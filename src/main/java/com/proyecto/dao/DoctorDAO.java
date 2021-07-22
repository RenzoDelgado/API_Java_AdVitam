package com.proyecto.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.modelo.Doctor;

public interface DoctorDAO extends JpaRepository<Doctor, Integer>{

	@Query(value="SELECT * from tb_doctor doc where doc.idEspecialidad =  :id ",nativeQuery=true)
	List<Doctor> doctorxespecialidad(@Param("id") int id);
	
	
}



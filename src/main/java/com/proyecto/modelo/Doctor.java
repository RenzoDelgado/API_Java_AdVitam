package com.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="tb_doctor" )
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cod_doctor;
	private String nombredoctor;
	private String apellidodoctor;
	
	@OneToOne
	@JoinColumn(name = "idespecialidad")
	private Especialidad especialidad;
	
	private String sexo;
	private String nrocolegiatura;
	private String foto;
	
	public String getUniversidaddoctor() {
		return universidaddoctor;
	}
	public void setUniversidaddoctor(String universidaddoctor) {
		this.universidaddoctor = universidaddoctor;
	}
	private String universidaddoctor;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCod_doctor() {
		return cod_doctor;
	}
	public void setCod_doctor(String cod_doctor) {
		this.cod_doctor = cod_doctor;
	}
	public String getNombredoctor() {
		return nombredoctor;
	}
	public void setNombredoctor(String nombredoctor) {
		this.nombredoctor = nombredoctor;
	}
	public String getApellidodoctor() {
		return apellidodoctor;
	}
	public void setApellidodoctor(String apellidodoctor) {
		this.apellidodoctor = apellidodoctor;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getNroColegiatura() {
		return nrocolegiatura;
	}
	public void setNroColegiatura(String nrocolegiatura) {
		this.nrocolegiatura = nrocolegiatura;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}

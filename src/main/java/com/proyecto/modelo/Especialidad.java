package com.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_especialidad")
public class Especialidad {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String descripcion;
	private int tiempoatencion;
	private int estado;
	private String imgespecialidad;
	
	public String getImgespecialidad() {
		return imgespecialidad;
	}
	public void setImgespecialidad(String imgespecialidad) {
		this.imgespecialidad = imgespecialidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getTiempoatencion() {
		return tiempoatencion;
	}
	public void setTiempoatencion(int tiempoatencion) {
		this.tiempoatencion = tiempoatencion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}

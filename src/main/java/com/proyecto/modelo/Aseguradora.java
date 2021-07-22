package com.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_aseguradora")
public class Aseguradora {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	private String descripcion_asg;
	private int estado;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion_asg() {
		return descripcion_asg;
	}
	public void setDescripcion_asg(String descripcion_asg) {
		this.descripcion_asg = descripcion_asg;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}

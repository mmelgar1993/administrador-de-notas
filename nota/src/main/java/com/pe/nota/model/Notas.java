package com.pe.nota.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Notas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idNotas;
	@Column(name = "descripcion_notas")
	private String descripcionNotas;
	
	private String usuarioCreacion;
	public Integer getIdNotas() {
		return idNotas;
	}
	public void setIdNotas(Integer idNotas) {
		this.idNotas = idNotas;
	}
	public String getDescripcionNotas() {
		return descripcionNotas;
	}
	public void setDescripcionNotas(String descripcionNotas) {
		this.descripcionNotas = descripcionNotas;
	}
	public String getUsuarioCreacion() {
		return usuarioCreacion;
	}
	public void setUsuarioCreacion(String usuarioCreacion) {
		this.usuarioCreacion = usuarioCreacion;
	}
	
	
	

}

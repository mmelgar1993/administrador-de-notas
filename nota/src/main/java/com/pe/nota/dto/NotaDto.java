package com.pe.nota.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NotaDto {
	private Integer idNotas;
	@NotNull
	@Size(min = 3)
	private String descripcionNotas;
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
	
	

}

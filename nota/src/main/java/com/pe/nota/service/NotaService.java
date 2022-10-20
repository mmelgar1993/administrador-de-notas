package com.pe.nota.service;

import java.util.List;

import org.springframework.security.core.Authentication;

import com.pe.nota.model.Notas;

public interface NotaService {
	Notas registras(Notas notas,Authentication authentication);
	Notas modificar(Notas notas,Authentication authentication);
	List<Notas> listar(Authentication authentication);
	Notas listarPorId(Integer idNota,Authentication authentication);
	void eliminar(Integer id);

}

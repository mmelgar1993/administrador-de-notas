package com.pe.nota.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.nota.model.Notas;

public interface NotaDao extends JpaRepository<Notas, Integer>{

}

package com.pe.nota.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.nota.model.Usuario;

public interface UsuarioDao extends JpaRepository<Usuario, Integer>  {

	//from usuario where username = ?
	//@Query("FROM Usuario us where us.username = ?")
	//Derived Query
	Usuario findOneByUsername(String username);	
}

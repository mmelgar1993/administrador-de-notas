package com.pe.nota.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.pe.nota.dao.NotaDao;
import com.pe.nota.model.Notas;
import com.pe.nota.service.NotaService;
@Service
public class NotaServiceImpl implements NotaService {
	
	@Autowired
	private NotaDao notaDao;

	@Override
	public Notas registras(Notas notas,Authentication authentication) {
		// TODO Auto-generated method stub
		notas.setUsuarioCreacion(authentication.getName());
		return notaDao.save(notas);
	}

	@Override
	public Notas modificar(Notas notas,Authentication authentication) {
		// TODO Auto-generated method stub
		notas.setUsuarioCreacion(authentication.getName());
		return notaDao.save(notas);
	}

	@Override
	public List<Notas> listar(Authentication authentication) {
		// TODO Auto-generated method stub
		List<Notas> list = notaDao.findAll();
		List<Notas> listas = new ArrayList<Notas>();
		for (Notas notas : list) {
			if(notas.getUsuarioCreacion().equals(authentication.getName())) {
				listas.add(notas);
			}
		}
		
		return listas;
		
	}

	@Override
	public Notas listarPorId(Integer idNota,Authentication authentication) {
		Optional<Notas> op = notaDao.findById(idNota);
		return op.isPresent() ? op.get() : null;
	}

	@Override
	public void eliminar(Integer id) {
		notaDao.deleteById(id);
		
	}

}

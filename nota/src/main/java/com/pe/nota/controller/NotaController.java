package com.pe.nota.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.nota.dto.NotaDto;
import com.pe.nota.exception.ModeloNotFoundException;
import com.pe.nota.model.Notas;
import com.pe.nota.service.NotaService;

@RestController
@RequestMapping("/notas")
public class NotaController {
	@Autowired
	private NotaService notaService;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<NotaDto>> listar(Authentication authentication) throws Exception {
		List<NotaDto> lista = notaService.listar(authentication).stream().map(p -> mapper.map(p, NotaDto.class)).collect(Collectors.toList());
		
		return new ResponseEntity<>(lista, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NotaDto> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Notas notas1 = notaService.listarPorId(id);
		if(Objects.isNull(notas1)) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		NotaDto dto = mapper.map(notas1, NotaDto.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);
		
	}
	
	@PostMapping
	public ResponseEntity<NotaDto> registrar(@Valid @RequestBody NotaDto notas, Authentication authentication)throws Exception {
		Notas notas1 = mapper.map(notas, Notas.class);
		notas1 = notaService.registras(notas1, authentication);
		NotaDto dto = mapper.map(notas1, NotaDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		
	}
	
	@PutMapping
	public ResponseEntity<NotaDto> modificar(NotaDto notaDto)throws Exception {
		Notas obj = notaService.listarPorId(notaDto.getIdNotas());
		
		if(Objects.isNull(obj)) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + notaDto.getIdNotas());
		}
		
		Notas p = mapper.map(notaDto, Notas.class);		
		Notas pac = notaService.modificar(p);
		NotaDto dtoResponse = mapper.map(pac, NotaDto.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id)throws Exception {
		 notaService.eliminar(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}

}

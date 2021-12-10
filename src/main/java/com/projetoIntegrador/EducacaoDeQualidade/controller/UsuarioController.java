package com.projetoIntegrador.EducacaoDeQualidade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;
import com.projetoIntegrador.EducacaoDeQualidade.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")

public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

}

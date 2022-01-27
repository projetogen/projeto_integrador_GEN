package com.projetoIntegrador.EducacaoDeQualidade.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;
import com.projetoIntegrador.EducacaoDeQualidade.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity<List<UsuarioModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não existente"));
	}

	@PostMapping("/save")
	public ResponseEntity<UsuarioModel> post(@Valid @RequestBody UsuarioModel usuario) {
		return ResponseEntity.status(200).body(repository.save(usuario));
	}

	@PutMapping("/update")
	public ResponseEntity<UsuarioModel> put(@Valid @RequestBody UsuarioModel usuario) {
		return ResponseEntity.status(200).body(repository.save(usuario));
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		repository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

}

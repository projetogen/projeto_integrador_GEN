package com.projetoIntegrador.EducacaoDeQualidade.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.projetoIntegrador.EducacaoDeQualidade.model.TemaModel;
import com.projetoIntegrador.EducacaoDeQualidade.repository.TemaRepository;

@RestController
@RequestMapping("/tema")
@CrossOrigin("*")

public class TemaController {
	@Autowired
	private TemaRepository repository;

	@GetMapping
	public ResponseEntity<List<TemaModel>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TemaModel> GetById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não existente"));
	}
	
	@PostMapping ("/save")
	public ResponseEntity<TemaModel>post(@Valid @RequestBody TemaModel tema){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(tema));
	}

	@PutMapping("/update")
	public ResponseEntity<TemaModel> put (@Valid @RequestBody TemaModel tema) {
		return ResponseEntity.status(200).body(repository.save(tema));
	}
}

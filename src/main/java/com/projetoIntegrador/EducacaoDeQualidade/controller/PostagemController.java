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

import com.projetoIntegrador.EducacaoDeQualidade.model.PostagemModel;
import com.projetoIntegrador.EducacaoDeQualidade.repository.PostagemRepository;

@RestController
@RequestMapping("/postagem")
@CrossOrigin("*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity<List<PostagemModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PostagemModel> getById(@PathVariable Long id) {
		return repository.findById(id).map(resp -> ResponseEntity.status(200).body(resp))
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "id não existente"));
	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<PostagemModel>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping("/save")
	public ResponseEntity<PostagemModel> post(@Valid @RequestBody PostagemModel postagem) {
		return ResponseEntity.status(201).body(repository.save(postagem));
	}
	
	@PutMapping("/update")
	public ResponseEntity<PostagemModel> put (@Valid @RequestBody PostagemModel postagem){
		return ResponseEntity.status(200).body(repository.save(postagem));
	}
	
	@DeleteMapping("/remove/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

}

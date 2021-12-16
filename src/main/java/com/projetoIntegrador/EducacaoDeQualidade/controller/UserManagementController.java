package com.projetoIntegrador.EducacaoDeQualidade.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoIntegrador.EducacaoDeQualidade.model.UserLogin;
import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;
import com.projetoIntegrador.EducacaoDeQualidade.service.UsuarioService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserManagementController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Authentication(@Valid @RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(401).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioModel> post(@Valid @RequestBody UsuarioModel usuario) {
		return ResponseEntity.status(201).body(usuarioService.CadastrarUsuario(usuario));
	}

}
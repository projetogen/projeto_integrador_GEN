package com.projetoIntegrador.EducacaoDeQualidade.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projetoIntegrador.EducacaoDeQualidade.model.UserLogin;
import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;
import com.projetoIntegrador.EducacaoDeQualidade.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public UsuarioModel CadastrarUsuario(UsuarioModel usuario) {
		Optional<UsuarioModel> optionalemail = repository.findByEmail(usuario.getEmail());
		Optional<UsuarioModel> optionalusuario = repository.findAllByUsuario(usuario.getUsuario());
		if (optionalemail.isEmpty() && optionalusuario.isEmpty()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

			String senhaencoder = encoder.encode(usuario.getSenha());
			usuario.setSenha(senhaencoder);
			
			if (usuario.getFoto() == null) {
				usuario.setFoto("https://semeandoafeto.imadel.org.br/packages/trustir/exclusiva/img/user_placeholder.png");
			}

			return repository.save(usuario);
		} else if (optionalemail.isPresent()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "email já existente");
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "usuário já existente");
		}
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> email = repository.findByEmail(user.get().getEmail());
		Optional<UsuarioModel> usuario = repository.findAllByUsuario(user.get().getUsuario());

		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {

				String auth = user.get().getUsuario() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				user.get().setUsuario(usuario.get().getUsuario());
				user.get().setSenha(usuario.get().getSenha());
				user.get().setEmail(usuario.get().getEmail());
				user.get().setFoto(usuario.get().getFoto());
				user.get().setTipo(usuario.get().getTipo());
				user.get().setId(usuario.get().getId());
				

				return user;

			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha incorreta!");
			}
		} else if (email.isPresent()) {
			if (encoder.matches(user.get().getSenha(), email.get().getSenha())) {
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setToken(authHeader);
				user.get().setEmail(email.get().getEmail());
				user.get().setSenha(email.get().getSenha());

				return user;
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha incorreta!");
			}
		} else {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email ou usuário incorreto!");
		}
	}
}

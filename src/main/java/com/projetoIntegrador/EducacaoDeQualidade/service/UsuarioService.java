package com.projetoIntegrador.EducacaoDeQualidade.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projetoIntegrador.EducacaoDeQualidade.model.UserLogin;
import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;
import com.projetoIntegrador.EducacaoDeQualidade.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public UsuarioModel CadastrarUsuario (UsuarioModel usuario) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaencoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaencoder);
		
		return repository.save(usuario);
	}
	
	public Optional<UserLogin> Logar (Optional<UserLogin> user) {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuario = repository.findAllByUsuario(user.get().getEmail());
		
		if (usuario.isPresent()) {
			if (encoder.matches(user.get().getSenha(), usuario.get().getSenha())) {
				
				String auth = user.get().getEmail() + ":" + user.get().getSenha();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " +  new String(encodedAuth);
				
				user.get().setToken(authHeader);
				user.get().setEmail(usuario.get().getEmail());
				user.get().setSenha(usuario.get().getSenha());
				
				return user;
			}
		}
		return null;
	}
}

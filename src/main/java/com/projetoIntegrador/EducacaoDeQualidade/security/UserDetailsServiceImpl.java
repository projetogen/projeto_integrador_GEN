package com.projetoIntegrador.EducacaoDeQualidade.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;
import com.projetoIntegrador.EducacaoDeQualidade.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException{
		
		Optional<UsuarioModel> user = userRepository.findAllByUsuario(usuario);
		user.orElseThrow(()-> new UsernameNotFoundException (usuario + "not found"));
		
		return user.map(UserDetails::new).get();
		
	}
	
}

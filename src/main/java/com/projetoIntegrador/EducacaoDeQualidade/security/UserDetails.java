package com.projetoIntegrador.EducacaoDeQualidade.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.projetoIntegrador.EducacaoDeQualidade.model.UsuarioModel;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String usuario;
	
	private String senha;
	
	private List<GrantedAuthority>authorities;

	
	
	public UserDetails(UsuarioModel user) {
		this.usuario = user.getUsuario();
	
		this.senha = user.getSenha();
	}
	

	public UserDetails() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

package com.projetoIntegrador.EducacaoDeQualidade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuario")
public class UsuarioModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private @NotNull @Size(min = 8, max = 50) String nomecompleto;

	private @NotNull @Size(min = 8, max = 30) String email;

	private @NotNull @Size(min = 4, max = 50) String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomecompleto() {
		return nomecompleto;
	}

	public void setNomecompleto(String nomecompleto) {
		this.nomecompleto = nomecompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}

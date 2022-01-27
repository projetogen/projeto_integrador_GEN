	package com.projetoIntegrador.EducacaoDeQualidade.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Usuario")
public class UsuarioModel {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

	private @NotNull @Size(min = 8, max = 50) String nome;
	
	private @NotNull @Size(min = 3, max = 25) String usuario;
	
	private @NotNull @Email @Size(min = 5, max = 50) String email;

	private @NotNull @Size(min = 5) String senha;
	
	private String foto;
	
	private String tipo;
	
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties ("usuario")
	private List<PostagemModel> postagem = new ArrayList<>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
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


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public List<PostagemModel> getPostagem() {
		return postagem;
	}


	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}

	
}

package com.projetoIntegrador.EducacaoDeQualidade.model;



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

import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Usuario")
public class UsuarioModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	private @NotNull @Size(min = 8, max = 50) String nome;
	
	@NotNull @Size(min = 3, max = 25)
	private String usuario;
	
	@NotNull @Email @Size(min = 5, max = 50)
	private  String email;

	@NotNull @Size(min = 5)
	private String senha;
	
	@URL @Nullable
	private String foto;
	
	private String tipo;
	
	@OneToMany(mappedBy = "usuario", cascade = {CascadeType.REFRESH, CascadeType.REMOVE})
	@JsonIgnoreProperties ("usuario")
	private List<PostagemModel> postagem;

	
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

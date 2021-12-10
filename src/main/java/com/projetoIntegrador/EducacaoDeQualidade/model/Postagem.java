package com.projetoIntegrador.EducacaoDeQualidade.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.aspectj.weaver.ast.Test;
import org.hibernate.validator.constraints.URL;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Campo obrigatório")
	@Size(min = 2, max = 255, message = "Tamanho mínimo é de 2 e o máximo é de 255 caracteres")
	private String titulo;

	@NotBlank(message = "Campo obrigatório")
	@Size(min = 2, max = 8000, message = "Tamanho mínimo é de 2 e o máximo é de 8000 caracteres")
	private String texto;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());

	private int curtida;

	@URL(message = "A imagem do usuario precisa ser um link")
	private String imagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCurtida() {
		return curtida;
	}

	public void setCurtida(int curtida) {
		this.curtida = curtida;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public UsuarioModel getUsuario() {
		return getUsuario();
	}

	public void setUsuario(UsuarioModel usuario) {
	}

	public Test getTema() {
		return getTema();
	}

	public void setTema(Test tema) {
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
package com.projetoIntegrador.EducacaoDeQualidade.model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "postagem")
public class PostagemModel {

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


	@Size(max = 5000, message = "O link da foto não pode ter mais de 5.000 caracteres")
	@URL(message= "o link deve ser valido")
	private String imagem;
	
	@ManyToOne
	@JoinColumn(name = "fk_tema")
	@JsonIgnoreProperties("postagem")
	private TemaModel tema;

	@ManyToOne
	@JoinColumn(name = "fk_usuario")
	@JsonIgnoreProperties("postagem")
	private UsuarioModel usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public TemaModel getTema() {
		return tema;
	}

	public void setTema(TemaModel tema) {
		this.tema = tema;
	}

	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
}
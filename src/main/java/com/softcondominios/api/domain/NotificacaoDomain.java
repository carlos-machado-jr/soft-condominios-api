package com.softcondominios.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_notificacao")
public class NotificacaoDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(25)", nullable = false)
	@NotNull
	private String titulo;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String descricao;
	
	@Column(columnDefinition = "varchar(50)")
	private String criador;
	
	@Column(columnDefinition = "varchar(50)")
	private String tipo;
	
	@Column(columnDefinition = "tinyint")
	private boolean usuarioVisualizou;
	
	
	private String linkId;
	
	@ManyToOne
	@JoinColumn(name = "not_usr_id")
	private UserDomain usuario;

	
	public NotificacaoDomain() {
		// TODO Auto-generated constructor stub
	}

	

	public NotificacaoDomain(@NotNull String titulo, String descricao, String criador, String tipo, String linkId, UserDomain usuario) {
		super();
		this.id = null;
		this.titulo = titulo;
		this.descricao = descricao;
		this.criador = criador;
		this.tipo = tipo;
		this.usuarioVisualizou = false;
		this.linkId = linkId;
		this.usuario = usuario;
	}



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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getCriador() {
		return criador;
	}


	public void setCriador(String criador) {
		this.criador = criador;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public boolean isUsuarioVisualizou() {
		return usuarioVisualizou;
	}


	public void setUsuarioVisualizou(boolean usuarioVisualizou) {
		this.usuarioVisualizou = usuarioVisualizou;
	}


	public String getLinkId() {
		return linkId;
	}


	public void setLinkId(String linkId) {
		this.linkId = linkId;
	}


	public UserDomain getUsuario() {
		return usuario;
	}


	public void setUsuario(UserDomain usuario) {
		this.usuario = usuario;
	}
	
	
}

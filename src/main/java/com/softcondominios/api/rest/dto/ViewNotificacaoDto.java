package com.softcondominios.api.rest.dto;

import com.softcondominios.api.domain.NotificacaoDomain;

public class ViewNotificacaoDto {
	private Long id;
	private String titulo;
	private String descricao;
	private String criador;
	private String tipo;
	private boolean usuarioVisualizou;
	private String linkId;
	
	
	public ViewNotificacaoDto() {
		// TODO Auto-generated constructor stub
	}
	


	public ViewNotificacaoDto(NotificacaoDomain notificacao) {
		super();
		this.id = notificacao.getId();
		this.titulo = notificacao.getTitulo();
		this.descricao = notificacao.getDescricao();
		this.criador = notificacao.getCriador();
		this.tipo = notificacao.getTipo();
		this.usuarioVisualizou = notificacao.isUsuarioVisualizou();
		this.linkId = notificacao.getLinkId();
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
	
	
}

package com.softcondominios.api.rest.dto;

import java.util.Set;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.domain.MensagemDomain;

public class ViewMensagemDto {
	private Long id;
	private String descricao;
	private String autor;
	private String login;
	private String linkFoto;
	private Set<GrupoPermissaoDomain> permissoes;
	
	
	public ViewMensagemDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ViewMensagemDto(MensagemDomain mensagem) {
		super();
		this.id = mensagem.getId();
		this.descricao = mensagem.getDescricao();
		this.autor = mensagem.getAutor();
		this.login = mensagem.getUsuario().getLogin();
		this.linkFoto = mensagem.getUsuario().getLinkFoto();
		this.permissoes = mensagem.getUsuario().getGrupoPermissao();
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}


	public Set<GrupoPermissaoDomain> getPermissoes() {
		return permissoes;
	}


	public void setPermissoes(Set<GrupoPermissaoDomain> permissoes) {
		this.permissoes = permissoes;
	}
	
	
	
	

}

package com.softcondominios.api.rest.dto;

import java.util.Set;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.domain.UserDomain;

public class UserDto {
	
	private Long id;
	private String login;
	private Set<GrupoPermissaoDomain> grupoPermissao;
	private String status;
	private String linkFoto;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(UserDomain user) {
		super();
		this.id = user.getId();
		this.login = user.getLogin();
		this.grupoPermissao = user.getGrupoPermissao();
		this.status = user.isStatus() ? "Ativado" : "Desativado";
		this.linkFoto = user.getLinkFoto(); 
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	

	public Set<GrupoPermissaoDomain> getGrupoPermissao() {
		return grupoPermissao;
	}

	public void setGrupoPermissao(Set<GrupoPermissaoDomain> grupoPermissao) {
		this.grupoPermissao = grupoPermissao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	
	
	
	
}

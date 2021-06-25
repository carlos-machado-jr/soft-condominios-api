package com.softcondominios.api.rest.dto;

import com.softcondominios.api.domain.UserDomain;

public class UserDto {
	
	private Long id;
	private String email;
	private String grupoPermissao;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(UserDomain user) {
		super();
		this.id = user.getUserId();
		this.email = user.getUserLogin();
		this.grupoPermissao = user.getUserGroup().getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String nome) {
		this.email = nome;
	}


	public String getGrupoPermissao() {
		return grupoPermissao;
	}

	public void setGrupoPermissao(String grupoPermissao) {
		this.grupoPermissao = grupoPermissao;
	}
	
	
	
	
}

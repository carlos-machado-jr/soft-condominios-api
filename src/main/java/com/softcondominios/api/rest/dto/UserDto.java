package com.softcondominios.api.rest.dto;

public class UserDto {
	
	private Long id;
	private String nome;
	private String senha;
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(Long id, String nome, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.senha = senha;
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}

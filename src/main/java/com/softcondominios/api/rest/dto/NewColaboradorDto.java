package com.softcondominios.api.rest.dto;

public class NewColaboradorDto {
	
	private String nome;
	private String sobrenome;
	private String email;
	private String cpf;
	private String status;
	private String login;
	private String senha;
	private String linkFoto;
	private String funcao;
	
	public NewColaboradorDto() {
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}


	public String getLinkFoto() {
		return linkFoto;
	}


	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	
	
}

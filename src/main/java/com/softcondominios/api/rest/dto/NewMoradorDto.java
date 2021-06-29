package com.softcondominios.api.rest.dto;

public class NewMoradorDto {
	
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String cpf;
	private String apartamento;
	private String bloco;
	private String linkFoto;
	
	public NewMoradorDto() {
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


	public String getApartamento() {
		return apartamento;
	}


	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}


	public String getBloco() {
		return bloco;
	}


	public void setBloco(String bloco) {
		this.bloco = bloco;
	}





	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getLinkFoto() {
		return linkFoto;
	}


	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	
	

}

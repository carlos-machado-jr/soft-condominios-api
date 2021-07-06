package com.softcondominios.api.rest.dto;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.MoradorDomain;

public class ViewMoradorDto {
	private Long id;
	private String nome;
	private String sobrenome;
	private String email;
	private String cpf;
	private String apartamento;
	private String bloco;
	private ViewCondominioDto condominio;
	
	public ViewMoradorDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ViewMoradorDto(MoradorDomain morador) {
		this.id = morador.getId();
		this.nome = morador.getNome();
		this.sobrenome = morador.getSobrenome();
		this.email = morador.getEmail();
		this.cpf = morador.getCpf();
		this.apartamento = morador.getApartamento();
		this.bloco = morador.getBloco();
		this.condominio = convertDto(morador.getCondominio());
	}
	
	private ViewCondominioDto convertDto(CondominioDomain c) {
		return new ViewCondominioDto(c);
		 
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

	public ViewCondominioDto getCondominio() {
		return condominio;
	}

	public void setCondominio(ViewCondominioDto condominio) {
		this.condominio = condominio;
	}

	
	
}

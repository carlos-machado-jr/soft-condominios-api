package com.softcondominios.api.rest.dto;

public class NewVisitanteDto {
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private String tipoVisitante;
	private String bloco;
	private String apartamento;
	private String observacao;
	private long condominio;
	private boolean status;
	
	
	public NewVisitanteDto() {
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


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTipoVisitante() {
		return tipoVisitante;
	}


	public void setTipoVisitante(String tipoVisitante) {
		this.tipoVisitante = tipoVisitante;
	}


	public String getBloco() {
		return bloco;
	}


	public void setBloco(String bloco) {
		this.bloco = bloco;
	}


	public String getApartamento() {
		return apartamento;
	}


	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}


	

	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	

	public long getCondominio() {
		return condominio;
	}


	public void setCondominio(long condominio) {
		this.condominio = condominio;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}

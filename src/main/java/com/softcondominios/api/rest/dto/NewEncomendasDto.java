package com.softcondominios.api.rest.dto;

public class NewEncomendasDto {
	
	private String descricao;
	private String destinatario;
	private String apartamento;
	private String bloco;
	
	
	
	public NewEncomendasDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public NewEncomendasDto(String descricao, String destinatario) {
		super();
		this.descricao = descricao;
		this.destinatario = destinatario;
	}



	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getDestinatario() {
		return destinatario;
	}


	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	
	
	
}

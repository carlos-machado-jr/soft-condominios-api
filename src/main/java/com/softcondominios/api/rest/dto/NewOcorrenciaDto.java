package com.softcondominios.api.rest.dto;

public class NewOcorrenciaDto {
	
	private String titulo;
	private String descricao;
	private String linkArquivo;
	private String status;

	
	public NewOcorrenciaDto() {
		// TODO Auto-generated constructor stub
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


	public String getLinkArquivo() {
		return linkArquivo;
	}


	public void setLinkArquivo(String linkArquivo) {
		this.linkArquivo = linkArquivo;
	}



	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

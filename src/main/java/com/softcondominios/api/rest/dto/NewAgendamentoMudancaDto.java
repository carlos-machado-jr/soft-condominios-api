package com.softcondominios.api.rest.dto;

public class NewAgendamentoMudancaDto {
	private String data;
	private String hora;
	private String observacao;
	
	
	public NewAgendamentoMudancaDto() {
		// TODO Auto-generated constructor stub
	}


	public String getData() {
		return data;
	}


	public void setData(String data) {
		this.data = data;
	}


	public String getHora() {
		return hora;
	}


	public void setHora(String hora) {
		this.hora = hora;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}

package com.softcondominios.api.rest.dto;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;

public class ViewAgendamentoMudancaDto {
	private Long id;
	private String data;
	private String hora;
	private String observacao;
	private ViewMoradorDto morador;
	
	public ViewAgendamentoMudancaDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public ViewAgendamentoMudancaDto(AgendamentoMudancaDomain agendamento) {
		super();
		this.id = agendamento.getId();
		String[] datetime = agendamento.getDataHora().split(" ");
		this.data = datetime[0];
		this.hora = datetime[1];
		this.observacao = agendamento.getObservacao();
		this.morador = new ViewMoradorDto(agendamento.getMorador());
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
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

	public ViewMoradorDto getMorador() {
		return morador;
	}

	public void setMorador(ViewMoradorDto morador) {
		this.morador = morador;
	}
	
	
}

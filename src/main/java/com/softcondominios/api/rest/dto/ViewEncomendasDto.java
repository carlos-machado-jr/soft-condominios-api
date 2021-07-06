package com.softcondominios.api.rest.dto;

import com.softcondominios.api.domain.EncomendaDomain;

public class ViewEncomendasDto {
	
	private String descricao;
	private String destinatario;
	private String data;
	private String hora;
	private String status;
	private ViewMoradorDto morador;
	
	public ViewEncomendasDto() {
		// TODO Auto-generated constructor stub
	}

	public ViewEncomendasDto(EncomendaDomain encomenda) {
		super();
		this.descricao = encomenda.getDescricao();
		this.destinatario = encomenda.getDestinatario();
		String[] datetime =  encomenda.getDataCriacao().split(" ");
		this.data =datetime[0];
		this.hora = datetime[1];
		this.status = encomenda.isStatus() ? "Não entregue" : "Entregue";
		this.morador = new ViewMoradorDto(encomenda.getMorador());
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ViewMoradorDto getMorador() {
		return morador;
	}

	public void setMorador(ViewMoradorDto morador) {
		this.morador = morador;
	}
	
	
	
}

package com.softcondominios.api.rest.dto;

import org.springframework.util.StringUtils;

import com.softcondominios.api.domain.EncomendaDomain;

public class ViewEncomendasDto {
	private Long id;
	private String descricao;
	private String destinatario;
	private String dataCriacao;
	private String horaCriacao;
	private String dataModificacao;
	private String horaModificacao;
	private String dataEntrega;
	private String horaEntrega;
	private String status;
	private String autor;
	private ViewMoradorDto morador;
	
	public ViewEncomendasDto() {
		// TODO Auto-generated constructor stub
	}

	public ViewEncomendasDto(EncomendaDomain encomenda) {
		super();
		this.id = encomenda.getId();
		this.descricao = encomenda.getDescricao();
		this.destinatario = encomenda.getDestinatario();
		String[] datetime =  encomenda.getDataCriacao().split(" ");
		String[] datetimeModificacao = StringUtils.hasText(encomenda.getDataModificacao()) ? encomenda.getDataModificacao().split(" ") : null;
		String[] datetimeEntrega =  StringUtils.hasText(encomenda.getDataEntrega()) ? encomenda.getDataEntrega().split(" ") : null;
		this.dataCriacao = datetime[0];
		this.horaCriacao = datetime[1];
		this.dataModificacao = datetimeModificacao != null ? datetimeModificacao[0] : null;
		this.horaModificacao = datetimeModificacao != null ? datetimeModificacao[1] : null;
		this.dataEntrega = datetimeEntrega != null ? datetimeEntrega[0] : null;
		this.horaEntrega = datetimeEntrega != null ? datetimeEntrega[1] : null;
		this.status = encomenda.isStatus() ? "Entregue" : "Não entregue";
		this.morador = new ViewMoradorDto(encomenda.getMorador());
		this.autor = encomenda.getAutor();
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return dataCriacao;
	}

	public void setData(String data) {
		this.dataCriacao = data;
	}

	public String getHora() {
		return horaCriacao;
	}

	public void setHora(String hora) {
		this.horaCriacao = hora;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public ViewMoradorDto getMorador() {
		return morador;
	}

	public void setMorador(ViewMoradorDto morador) {
		this.morador = morador;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getHoraCriacao() {
		return horaCriacao;
	}

	public void setHoraCriacao(String horaCriacao) {
		this.horaCriacao = horaCriacao;
	}

	public String getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(String dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public String getHoraModificacao() {
		return horaModificacao;
	}

	public void setHoraModificacao(String horaModificacao) {
		this.horaModificacao = horaModificacao;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(String horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
	
	
}

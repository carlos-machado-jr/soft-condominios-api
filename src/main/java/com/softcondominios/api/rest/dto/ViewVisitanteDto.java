package com.softcondominios.api.rest.dto;

import java.util.Objects;

import com.softcondominios.api.domain.VisitanteDomain;

public class ViewVisitanteDto {
	private Long id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String tipoVisitante;
	private String bloco;
	private String apartamento;
	private String dataEntrada;
	private String horaEntrada;
	private String dataSaida;
	private String horaSaida;
	private String observacao;
	private String nomePorteiro;
	private String status;
	
	public ViewVisitanteDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ViewVisitanteDto(VisitanteDomain visitante) {
		super();
		this.id = visitante.getId();
		this.nome = visitante.getNome();
		this.sobrenome = visitante.getSobrenome();
		this.cpf = visitante.getCpf();
		this.tipoVisitante = visitante.getTipoVisitante();
		this.bloco = visitante.getBloco();
		this.apartamento = visitante.getApartamento();
		String[] datetimeEntrada = visitante.getDataHoraEntrada().split(" ");
		this.dataEntrada = datetimeEntrada[0];
		this.horaEntrada = datetimeEntrada[1];
		if(Objects.nonNull(visitante.getDataHoraSaida())) {
			String[] datetimeSaida = visitante.getDataHoraSaida().split(" ");
			this.dataSaida = datetimeSaida[0];
			this.horaSaida = datetimeSaida[1];
		}
		this.observacao = visitante.getObservacao();
		this.nomePorteiro = visitante.getNomePorteiro();
		this.status = visitante.isStatus() ? "Em andamento" : "Finalizado";
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

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNomePorteiro() {
		return nomePorteiro;
	}

	public void setNomePorteiro(String nomePorteiro) {
		this.nomePorteiro = nomePorteiro;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}

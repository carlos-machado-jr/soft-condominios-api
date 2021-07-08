package com.softcondominios.api.rest.dto;

import java.util.Objects;

import com.softcondominios.api.domain.OcorrenciaDomain;

public class ViewOcorrenciaDto {
	
	private Long id;
	private String titulo;
	private String descricao;
	private String linkArquivo;
	private String autor;
	private String status;
	private String dataCriacao;
	private String horaCriacao;
	private String dataFinalizado;
	private String horaFinalizado;
	private ViewMoradorDto morador;
	
	
	public ViewOcorrenciaDto() {
		// TODO Auto-generated constructor stub
	}
	
	


	public ViewOcorrenciaDto(OcorrenciaDomain ocorrencia) {
		super();
		this.id = ocorrencia.getId();
		this.titulo = ocorrencia.getTitulo();
		this.descricao = ocorrencia.getDescricao();
		this.linkArquivo = ocorrencia.getLinkArquivo();
		this.autor = ocorrencia.getAutor();
		this.status = ocorrencia.isStatus() ? "Em andamento" : "Finalizado";
		String[] datetimeCriacao = ocorrencia.getDataInicio().split(" ");
		this.dataCriacao = datetimeCriacao[0];
		this.horaCriacao = datetimeCriacao[1];
		if(Objects.nonNull(ocorrencia.getDataConcluido())) {
			String[] datetimeFinalizado = ocorrencia.getDataConcluido().split(" ");
			this.dataFinalizado = datetimeFinalizado[0];
			this.horaFinalizado = datetimeFinalizado[1];
			
		}
		
		this.morador = new ViewMoradorDto(ocorrencia.getMorador());
	}




	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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


	public String getDataFinalizado() {
		return dataFinalizado;
	}


	public void setDataFinalizado(String dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}


	public String getHoraFinalizado() {
		return horaFinalizado;
	}


	public void setHoraFinalizado(String horaFinalizado) {
		this.horaFinalizado = horaFinalizado;
	}


	public ViewMoradorDto getMorador() {
		return morador;
	}


	public void setMorador(ViewMoradorDto morador) {
		this.morador = morador;
	}
	
	
}

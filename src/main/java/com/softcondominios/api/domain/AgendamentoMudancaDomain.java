package com.softcondominios.api.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_agendamento_mudanca")
public class AgendamentoMudancaDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "datetime", nullable = false)
	private Date dataHora;
	
	@Column(columnDefinition = "varchar(250)", nullable = false)
	private String observacao;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	private boolean status;

	@ManyToOne
	@JoinColumn(name = "agm_mor_id")
	private MoradorDomain morador;
	
	
	public AgendamentoMudancaDomain() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getDataHora() {
		return dataHora;
	}


	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public MoradorDomain getMorador() {
		return morador;
	}


	public void setMorador(MoradorDomain morador) {
		this.morador = morador;
	}
	
	
}

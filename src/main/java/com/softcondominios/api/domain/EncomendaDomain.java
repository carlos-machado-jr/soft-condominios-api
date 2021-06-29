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
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_encomenda")
public class EncomendaDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	@NotNull
	private String descricao;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String destinatario;
	
	@Column(columnDefinition = "varchar(20)", nullable = false)
	private String bloco;
	
	@Column(columnDefinition = "varchar(20)", nullable = false)
	private String apartamento;
	
	@Column(columnDefinition = "datetime", nullable = false)
	private Date dataEntrega;
	
	
	@Column(columnDefinition = "tinyint", nullable = false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "enc_mor_id")
	private MoradorDomain morador;
	
	
	public EncomendaDomain() {
		// TODO Auto-generated constructor stub
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


	public Date getDataEntrega() {
		return dataEntrega;
	}


	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
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

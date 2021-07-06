package com.softcondominios.api.domain;


import java.io.Serializable;
import java.text.SimpleDateFormat;
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

import com.softcondominios.api.rest.dto.NewEncomendasDto;

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
	
	@Column(columnDefinition = "DATETIME", nullable = false)
	private String dataCriacao;
	
	@Column(columnDefinition = "DATETIME")
	private String dataModificacao;
	
	@Column(columnDefinition = "DATETIME")
	private String dataEntrega;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "enc_mor_id")
	private MoradorDomain morador;
	
	
	public EncomendaDomain() {
		// TODO Auto-generated constructor stub
	}

	
	public EncomendaDomain(NewEncomendasDto newEncomendas, MoradorDomain morador) {
		super();
		this.id = null;
		this.descricao = newEncomendas.getDescricao();
		this.destinatario = morador.getNome() + " " + morador.getSobrenome();
		this.bloco = morador.getBloco();
		this.apartamento = morador.getApartamento();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
//		this.dataCriacao = date.format(now);
		this.dataCriacao = date.format(now);
		this.status = false;
		this.morador = morador;
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


	public String getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	

	public String getDataModificacao() {
		return dataModificacao;
	}


	public void setDataModificacao(String dataModificacao) {
		this.dataModificacao = dataModificacao;
	}


	public String getDataEntrega() {
		return dataEntrega;
	}


	public void setDataEntrega(String dataEntrega) {
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

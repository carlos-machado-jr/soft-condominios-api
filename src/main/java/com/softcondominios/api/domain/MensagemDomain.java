package com.softcondominios.api.domain;

import java.io.Serializable;

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
@Table(name = "tb_mensagem")
public class MensagemDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
	@NotNull
	private String descricao;
	
	
	@ManyToOne
	@JoinColumn(name = "men_oco_id")
	private OcorrenciaDomain ocorrencia;
	
	public MensagemDomain() {
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

	public OcorrenciaDomain getOcorrencia() {
		return ocorrencia;
	}

	public void setOcorrencia(OcorrenciaDomain ocorrencia) {
		this.ocorrencia = ocorrencia;
	}
	
	
}

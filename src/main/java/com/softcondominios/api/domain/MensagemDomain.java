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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	@NotNull
	private String descricao;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String autor;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "men_oco_id")
	private OcorrenciaDomain ocorrencia;
	
	@ManyToOne
	@JoinColumn(name = "men_user_id")
	private UserDomain usuario;
	
	public MensagemDomain() {
		// TODO Auto-generated constructor stub
	}
	




	public MensagemDomain(@NotNull String descricao, OcorrenciaDomain ocorrencia, UserDomain usuario, String autor) {
		super();
		this.descricao = descricao;
		this.ocorrencia = ocorrencia;
		this.usuario = usuario;
		this.autor = autor;
	}



	
	

	public UserDomain getUsuario() {
		return usuario;
	}





	public void setUsuario(UserDomain usuario) {
		this.usuario = usuario;
	}





	public String getAutor() {
		return autor;
	}





	public void setAutor(String autor) {
		this.autor = autor;
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

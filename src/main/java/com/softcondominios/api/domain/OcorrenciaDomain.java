package com.softcondominios.api.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_ocorrencia")
public class OcorrenciaDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	@NotNull
	private String titulo;
	
	@Column(columnDefinition = "varchar(250)", nullable = false)
	private String descricao;
	
	@Column(columnDefinition = "datetime", nullable = false)
	private Date dataInicio;
	
	@Column(columnDefinition = "datetime")
	private Date dataConcluido;
	
	private String linkArquivo;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String autor;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	private boolean status;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String tipo;
	
	@OneToMany(mappedBy = "ocorrencia")
	private Set<MensagemDomain> mensagem = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "oco_mor_id")
	private MoradorDomain morador;
	
	public OcorrenciaDomain() {
		// TODO Auto-generated constructor stub
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


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataConcluido() {
		return dataConcluido;
	}


	public void setDataConcluido(Date dataConcluido) {
		this.dataConcluido = dataConcluido;
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


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public Set<MensagemDomain> getMensagem() {
		return mensagem;
	}


	public void setMensagem(Set<MensagemDomain> mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}

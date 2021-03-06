package com.softcondominios.api.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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

import com.softcondominios.api.rest.dto.NewOcorrenciaDto;

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
	private String dataInicio;
	
	@Column(columnDefinition = "datetime")
	private String dataConcluido;
	
	@Column(columnDefinition = "varchar(50)")
	private String residencia;
	

	
	private String linkArquivo;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String autor;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	private boolean status;
	

	
	@OneToMany(mappedBy = "ocorrencia")
	private Set<MensagemDomain> mensagem = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "oco_mor_id")
	private MoradorDomain morador;
	
	public OcorrenciaDomain() {
		// TODO Auto-generated constructor stub
	}

	

	public OcorrenciaDomain(NewOcorrenciaDto newOcorrenciaDto, MoradorDomain morador) {
		super();
		this.id = null;
		this.titulo = newOcorrenciaDto.getTitulo();
		this.descricao = newOcorrenciaDto.getDescricao();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		this.dataInicio = date.format(now);
		this.dataConcluido = null;
		this.residencia = "Bloco: " + morador.getBloco() + " Apt: " + morador.getApartamento();
		this.linkArquivo = newOcorrenciaDto.getLinkArquivo();
		this.autor = morador.getNome() + " " + morador.getSobrenome();
		this.status = true;
		this.mensagem = null;
		this.morador = morador;
	}
	
	
//	public OcorrenciaDomain(OcorrenciaDomain ocorrencia , NewOcorrenciaDto newOcorrenciaDto) {
//		super();
//		this.id = ocorrencia.getId();
//		this.titulo = Objects.isNull(newOcorrenciaDto.getTitulo()) ? ocorrencia.getTitulo() : newOcorrenciaDto.getTitulo();
//		this.descricao = Objects.isNull(newOcorrenciaDto.getDescricao()) ? ocorrencia.getDescricao() : newOcorrenciaDto.getDescricao();
//		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		Date now = new Date();
//		this.dataInicio = date.format(now);
//		this.dataConcluido = null;
//		this.residencia = "Bloco: " + morador.getBloco() + " Apt: " + morador.getApartamento();
//		this.linkArquivo = newOcorrenciaDto.getLinkArquivo();
//		this.autor = morador.getNome() + " " + morador.getSobrenome();
//		this.status = true;
//		this.mensagem = null;
//		this.morador = morador;
//	}



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


	public String getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}


	public String getDataConcluido() {
		return dataConcluido;
	}


	public void setDataConcluido(String dataConcluido) {
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




	public Set<MensagemDomain> getMensagem() {
		return mensagem;
	}


	public void setMensagem(Set<MensagemDomain> mensagem) {
		this.mensagem = mensagem;
	}


	public String getResidencia() {
		return residencia;
	}


	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}




	public MoradorDomain getMorador() {
		return morador;
	}


	public void setMorador(MoradorDomain morador) {
		this.morador = morador;
	}
	
	
	
}

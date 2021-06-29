package com.softcondominios.api.domain;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.softcondominios.api.rest.dto.NewMoradorDto;

@Entity
@Table(name = "tb_morador")
public class MoradorDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	@NotNull
	private String nome;
	
	@Column(columnDefinition = "varchar(150)", nullable = false)
	@NotNull
	private String sobrenome;
	
	@Column(columnDefinition = "varchar(150)", nullable = false, unique = true)
	@NotNull
	private String email;
	
	@Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
	@NotNull
	private String cpf;
	
	@Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
	@NotNull
	private String apartamento;
	
	@Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
	@NotNull
	private String bloco;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	@NotNull
	private boolean status;
	
	
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
	
	@ManyToOne
	@JoinColumn(name = "mor_con_id")
	private CondominioDomain condominio;
	
	@OneToMany(mappedBy = "morador")
	private Set<OcorrenciaDomain> ocorrencia = new HashSet<>();
	

	@OneToMany(mappedBy = "morador")
	private Set<EncomendaDomain> encomenda = new HashSet<>();
	
	@OneToOne
	@JoinColumn(name = "mor_userId", referencedColumnName = "id")
	private UserDomain usuario;
	
	@OneToMany(mappedBy = "morador")
	private Set<AgendamentoMudancaDomain> agendamentoMudanca = new HashSet<>();
	
	public MoradorDomain() {
		// TODO Auto-generated constructor stub
	}

	public MoradorDomain(NewMoradorDto newMoradorDto) {
		
		this.id = null;
		this.nome = newMoradorDto.getNome();
		this.sobrenome = newMoradorDto.getSobrenome();
		this.email = newMoradorDto.getEmail();
		this.cpf = newMoradorDto.getCpf();
		this.apartamento = newMoradorDto.getApartamento();
		this.bloco = newMoradorDto.getBloco();
		this.status = true;
		
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getApartamento() {
		return apartamento;
	}



	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}



	public String getBloco() {
		return bloco;
	}



	public void setBloco(String bloco) {
		this.bloco = bloco;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public CondominioDomain getCondominio() {
		return condominio;
	}



	public void setCondominio(CondominioDomain condominio) {
		this.condominio = condominio;
	}



	public Set<OcorrenciaDomain> getOcorrencia() {
		return ocorrencia;
	}



	public void setOcorrencia(Set<OcorrenciaDomain> ocorrencia) {
		this.ocorrencia = ocorrencia;
	}



	public Set<EncomendaDomain> getEncomenda() {
		return encomenda;
	}



	public void setEncomenda(Set<EncomendaDomain> encomenda) {
		this.encomenda = encomenda;
	}



	public Set<AgendamentoMudancaDomain> getAgendamentoMudanca() {
		return agendamentoMudanca;
	}



	public void setAgendamentoMudanca(Set<AgendamentoMudancaDomain> agendamentoMudanca) {
		this.agendamentoMudanca = agendamentoMudanca;
	}

	public UserDomain getUsuario() {
		return usuario;
	}

	public void setUsuario(UserDomain usuario) {
		this.usuario = usuario;
	}
	
	
	
}

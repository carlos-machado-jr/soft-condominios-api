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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softcondominios.api.rest.dto.NewCondominioDto;

@Entity
@Table(name = "tb_condominio")
public class CondominioDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(11)", nullable = false)
	@NotNull
	private String cep;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	@NotNull
	private String rua;
	
	@Column(columnDefinition = "varchar(10)")
	private String numero;
	
	@Column(columnDefinition = "varchar(200)", nullable = false, unique = true)
	@NotNull
	private String razaoSocial;
	
	@Column(columnDefinition = "varchar(200)", unique = true)
	private String nomeFantasia;
	
	@Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
	@NotNull
	private String cnpj;
	
	
	private String linkContratoSocial;
	
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
	
	@JsonIgnore
	@ManyToMany(mappedBy = "condominio")
	private Set<ColaboradorDomain> colaboradorDomain = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "condominio")
	private Set<MoradorDomain> moradorDomain = new HashSet<>();
	
	
	@ManyToOne
	@JoinColumn(name = "con_bar_id")
	private BairroDomain bairro;
	
	@JsonIgnore
	@OneToMany(mappedBy = "condominio")
	private Set<VisitanteDomain> visitantes;
	
	
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
	
	
	public CondominioDomain() {
		// TODO Auto-generated constructor stub
	}

	public CondominioDomain(NewCondominioDto condominio, Set<ColaboradorDomain> colaborador, BairroDomain bairro) {
		super();
		this.id = null;
		this.cep = condominio.getCep();
		this.rua = condominio.getRua().toLowerCase();
		this.numero = condominio.getNumero();
		this.razaoSocial = condominio.getRazaoSocial().toLowerCase();
		this.nomeFantasia = condominio.getNomeFantasia().toLowerCase();
		this.cnpj = condominio.getCnpj();
		this.linkContratoSocial = condominio.getLinkContrato();
		this.colaboradorDomain = colaborador;
		this.bairro = bairro;
	}


	
	//getters e setters -----------------------------------------------
	//getters e setters -----------------------------------------------
	//getters e setters -----------------------------------------------
	//getters e setters -----------------------------------------------
	//getters e setters -----------------------------------------------
	//getters e setters -----------------------------------------------
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getCep() {
		return cep;
	}
	
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	public String getRua() {
		return rua;
	}
	
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	
	public String getNumero() {
		return numero;
	}
	
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	
	public String getCnpj() {
		return cnpj;
	}
	
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	
	public String getLinkContratoSocial() {
		return linkContratoSocial;
	}
	
	
	public void setLinkContratoSocial(String linkContratoSocial) {
		this.linkContratoSocial = linkContratoSocial;
	}
	
	
	public Set<ColaboradorDomain> getColaboradorDomain() {
		return colaboradorDomain;
	}
	
	
	public void setColaboradorDomain(Set<ColaboradorDomain> colaboradorDomain) {
		this.colaboradorDomain = colaboradorDomain;
	}


	public Set<MoradorDomain> getMoradorDomain() {
		return moradorDomain;
	}


	public void setMoradorDomain(Set<MoradorDomain> moradorDomain) {
		this.moradorDomain = moradorDomain;
	}

	public BairroDomain getBairro() {
		return bairro;
	}

	public void setBairro(BairroDomain bairro) {
		this.bairro = bairro;
	}

	public Set<VisitanteDomain> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(Set<VisitanteDomain> visitantes) {
		this.visitantes = visitantes;
	}

	
	

		
		
	}

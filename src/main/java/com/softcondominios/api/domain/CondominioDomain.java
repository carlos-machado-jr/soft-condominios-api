package com.softcondominios.api.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(columnDefinition = "varchar(10)", nullable = false, unique = true)
	@NotNull
	@Length(min = 9, max = 9)
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
	
	
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
	
	
	public CondominioDomain() {
		// TODO Auto-generated constructor stub
	}


	public CondominioDomain(Long id, @NotNull @Length(min = 10, max = 10) String cep, @NotNull String rua, String numero,
			@NotNull String razaoSocial, String nomeFantasia, @NotNull String cnpj, String linkContratoSocial,
			Set<ColaboradorDomain> colaboradorDomain) {
		super();
		this.id = id;
		this.cep = cep;
		this.rua = rua;
		this.numero = numero;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.linkContratoSocial = linkContratoSocial;
		this.colaboradorDomain = colaboradorDomain;
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
	// hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	

	

		
		
	}

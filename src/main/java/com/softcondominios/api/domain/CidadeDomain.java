package com.softcondominios.api.domain;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_cidade")
public class CidadeDomain  implements Serializable {

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
	
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
	
	@ManyToOne
	@JoinColumn(name = "cid_est_id")
	private EstadoDomain estadoDomain;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "cidadeDomain")
	private Set<BairroDomain> bairroDomain;
	
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
	
	public CidadeDomain() {
		// TODO Auto-generated constructor stub
	}
	
	public CidadeDomain(Long id, @NotNull String descricao, EstadoDomain estadoDomain, Set<BairroDomain> bairroDomain) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.estadoDomain = estadoDomain;
		this.bairroDomain = bairroDomain;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public EstadoDomain getEstadoDomain() {
		return estadoDomain;
	}

	public void setEstadoDomain(EstadoDomain estadoDomain) {
		this.estadoDomain = estadoDomain;
	}

	public Set<BairroDomain> getBairroDomain() {
		return bairroDomain;
	}

	public void setBairroDomain(Set<BairroDomain> bairroDomain) {
		this.bairroDomain = bairroDomain;
	}
		

	
	
	

}

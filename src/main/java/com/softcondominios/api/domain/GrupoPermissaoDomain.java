package com.softcondominios.api.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_grupoPermissao")
public class GrupoPermissaoDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Column
	private String descricao;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "grupoPermissao")
	private List<UserDomain> userDomain;
	
	public GrupoPermissaoDomain() {
		// TODO Auto-generated constructor stub
	}
	
	public GrupoPermissaoDomain( String descricao) {
		super();
		
		this.descricao = descricao;
	
	}

	public GrupoPermissaoDomain(Long id, String descricao, List<UserDomain> userDomain) {
		super();
		Id = id;
		this.descricao = descricao;
		this.userDomain = userDomain;
	}
	
	
	

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<UserDomain> getUserDomain() {
		return userDomain;
	}

	public void setUserDomain(List<UserDomain> userDomain) {
		this.userDomain = userDomain;
	}

	
	
	
	
}

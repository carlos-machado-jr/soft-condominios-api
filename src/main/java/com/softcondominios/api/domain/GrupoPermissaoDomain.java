package com.softcondominios.api.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
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
	@OneToMany(mappedBy = "grupoPermissao")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((userDomain == null) ? 0 : userDomain.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GrupoPermissaoDomain other = (GrupoPermissaoDomain) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (userDomain == null) {
			if (other.userDomain != null)
				return false;
		} else if (!userDomain.equals(other.userDomain))
			return false;
		return true;
	}
	
	
	
	
}

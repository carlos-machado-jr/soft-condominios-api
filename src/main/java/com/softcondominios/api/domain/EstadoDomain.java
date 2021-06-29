package com.softcondominios.api.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_estado")
public class EstadoDomain  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(10)", nullable = false, unique = true)
	@NotNull
	private String UF;
	
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
	
	@JsonIgnore
	@OneToMany(mappedBy = "estadoDomain")
	private Set<CidadeDomain> cidadeDomain;

	
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
	
	public EstadoDomain() {
		// TODO Auto-generated constructor stub
	}

	
	public EstadoDomain(Long id, @NotNull String uF, Set<CidadeDomain> cidadeDomain) {
		super();
		this.id = id;
		UF = uF;
		this.cidadeDomain = cidadeDomain;
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

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public Set<CidadeDomain> getCidadeDomain() {
		return cidadeDomain;
	}

	public void setCidadeDomain(Set<CidadeDomain> cidadeDomain) {
		this.cidadeDomain = cidadeDomain;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((UF == null) ? 0 : UF.hashCode());
		result = prime * result + ((cidadeDomain == null) ? 0 : cidadeDomain.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		EstadoDomain other = (EstadoDomain) obj;
		if (UF == null) {
			if (other.UF != null)
				return false;
		} else if (!UF.equals(other.UF))
			return false;
		if (cidadeDomain == null) {
			if (other.cidadeDomain != null)
				return false;
		} else if (!cidadeDomain.equals(other.cidadeDomain))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}

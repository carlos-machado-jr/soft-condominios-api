package com.softcondominios.api.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_funcao")
public class FuncaoDomain implements Serializable {

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
	
	
	@OneToMany(mappedBy = "funcaoDomain")
	private List<ColaboradorDomain> colaboradorDomain;
	
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-

	public FuncaoDomain() {
		// TODO Auto-generated constructor stub
	}


	public FuncaoDomain(Long id, @NotNull String descricao, List<ColaboradorDomain> colaboradorDomain) {
		super();
		this.id = id;
		this.descricao = descricao;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public List<ColaboradorDomain> getColaboradorDomain() {
		return colaboradorDomain;
	}


	public void setColaboradorDomain(List<ColaboradorDomain> colaboradorDomain) {
		this.colaboradorDomain = colaboradorDomain;
	}
	
	// hashcode ----------------==============
		//hashcode ----------------==============
		//hashcode ----------------==============
		//hashcode ----------------==============
		//hashcode ----------------==============
		//hashcode ----------------==============
			

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((colaboradorDomain == null) ? 0 : colaboradorDomain.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
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
		FuncaoDomain other = (FuncaoDomain) obj;
		if (colaboradorDomain == null) {
			if (other.colaboradorDomain != null)
				return false;
		} else if (!colaboradorDomain.equals(other.colaboradorDomain))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

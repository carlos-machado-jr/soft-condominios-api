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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_bairro")
public class BairroDomain  implements Serializable {

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
	@JoinColumn(name = "bar_cid_id")
	private CidadeDomain cidadeDomain;
	
	@OneToMany(mappedBy = "bairro")
	private Set<CondominioDomain> condominio = new HashSet<>();
	
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
	
	public BairroDomain() {
		// TODO Auto-generated constructor stub
	}

	public BairroDomain(Long id, @NotNull String descricao, CidadeDomain cidadeDomain) {
		super();
		this.id = id;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CidadeDomain getCidadeDomain() {
		return cidadeDomain;
	}

	public void setCidadeDomain(CidadeDomain cidadeDomain) {
		this.cidadeDomain = cidadeDomain;
	}
	
	
	public Set<CondominioDomain> getCondominio() {
		return condominio;
	}

	public void setCondominio(Set<CondominioDomain> condominio) {
		this.condominio = condominio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidadeDomain == null) ? 0 : cidadeDomain.hashCode());
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
		BairroDomain other = (BairroDomain) obj;
		if (cidadeDomain == null) {
			if (other.cidadeDomain != null)
				return false;
		} else if (!cidadeDomain.equals(other.cidadeDomain))
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

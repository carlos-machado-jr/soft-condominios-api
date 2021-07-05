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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.softcondominios.api.rest.dto.NewColaboradorDto;

@Entity
@Table(name = "tb_colaborador")
public class ColaboradorDomain implements Serializable {

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
	
	@Column(columnDefinition = "tinyint", nullable = false)
	@NotNull
	private boolean status;
	
	private String funcao;
	
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
	
	@OneToOne
	@JoinColumn(name = "col_userId", referencedColumnName = "id")
	private UserDomain usuario;
	
	@ManyToMany
	@JoinTable(name="colaborador_has_condominio", joinColumns = {@JoinColumn(name="col_id")}, inverseJoinColumns = {@JoinColumn(name="con_id")})
	private Set<CondominioDomain> condominio = new HashSet<>();

	
	
	
	
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
//	construtores ------------//////////-
	
	
	
	public ColaboradorDomain() {
		// TODO Auto-generated constructor stub
	}

	public ColaboradorDomain(NewColaboradorDto newColaborador) {
		
		this.id = null;
		this.nome = newColaborador.getNome().toLowerCase();
		this.sobrenome = newColaborador.getSobrenome().toLowerCase();
		this.email = newColaborador.getEmail().toLowerCase();
		this.cpf = newColaborador.getCpf();
		this.funcao = newColaborador.getFuncao();
		this.status = true;
		
	}

	public ColaboradorDomain(Long id, @NotNull String nome, @NotNull String sobrenome, @NotNull String email,
			@NotNull String cpf, @NotNull boolean status, UserDomain usuario, Set<CondominioDomain> condominio,
			String funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.status = status;
		this.usuario = usuario;
		this.condominio = condominio;
		this.funcao = funcao;
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


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public UserDomain getUsuario() {
		return usuario;
	}


	public void setUsuario(UserDomain usuario) {
		this.usuario = usuario;
	}


	public Set<CondominioDomain> getCondominio() {
		return condominio;
	}


	public void setCondominio(Set<CondominioDomain> condominio) {
		this.condominio = condominio;
	}


	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	// hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	

	
}

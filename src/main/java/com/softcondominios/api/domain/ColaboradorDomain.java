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
import javax.persistence.ManyToOne;
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
	
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
	
	@OneToOne
	@JoinColumn(name = "col_userId", referencedColumnName = "id")
	private UserDomain usuario;
	
	@ManyToMany
	@JoinTable(name="rel_colaborador_condominio", joinColumns = {@JoinColumn(name="col_id")}, inverseJoinColumns = {@JoinColumn(name="con_id")})
	private Set<CondominioDomain> condominio = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "col_idFuncao", referencedColumnName = "id")
	private FuncaoDomain funcaoDomain;
	
	
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
		this.nome = newColaborador.getNome();
		this.sobrenome = newColaborador.getSobrenome();
		this.email = newColaborador.getEmail();
		this.cpf = newColaborador.getCpf();
		this.status = true;
		
	}

	public ColaboradorDomain(Long id, @NotNull String nome, @NotNull String sobrenome, @NotNull String email,
			@NotNull String cpf, @NotNull boolean status, UserDomain usuario, Set<CondominioDomain> condominio,
			FuncaoDomain funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.cpf = cpf;
		this.status = status;
		this.usuario = usuario;
		this.condominio = condominio;
		this.funcaoDomain = funcao;
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


	public FuncaoDomain getFuncao() {
		return funcaoDomain;
	}


	public void setFuncao(FuncaoDomain funcao) {
		this.funcaoDomain = funcao;
	}

	// hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	//hashcode ----------------==============
	

	
}

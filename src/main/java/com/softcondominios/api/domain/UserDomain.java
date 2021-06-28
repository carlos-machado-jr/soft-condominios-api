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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softcondominios.api.rest.dto.NewColaboradorDto;
import com.softcondominios.api.rest.dto.NewUserDto;

@Entity
@Table(name = "tb_user")
public class UserDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(100)", nullable = false, unique = true)
	private String login;
	
	@Column(nullable = false)
	private String password;
	
	
	private String linkFoto;
	
	@Column(columnDefinition = "tinyint")
	private boolean status;
	
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
	
	@ManyToMany
	@JoinTable(name="user_has_grupo_permissao", joinColumns = {@JoinColumn(name="usr_id")}, inverseJoinColumns = {@JoinColumn(name="grp_id")})
	private Set<GrupoPermissaoDomain> grupoPermissao = new HashSet<>();
	
	@JsonIgnore
	@OneToOne(mappedBy = "usuario")
	private ColaboradorDomain colaborador;
	
	public UserDomain() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDomain(NewUserDto newUser) {
		this.id = null;
		this.login = newUser.getEmail();
		this.password = newUser.getSenha();
		this.status = true;
		this.linkFoto = newUser.getLinkFoto();
	}
	
	public UserDomain(NewColaboradorDto newColaboradorDto) {
		this.id = null;
		this.login = newColaboradorDto.getEmail();
		this.password = newColaboradorDto.getSenha();
		this.status = true;
		this.linkFoto = newColaboradorDto.getLinkFoto();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public Set<GrupoPermissaoDomain> getGrupoPermissao() {
		return grupoPermissao;
	}

	public void setGrupoPermissao(Set<GrupoPermissaoDomain> grupoPermissao) {
		this.grupoPermissao = grupoPermissao;
	}

	public ColaboradorDomain getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorDomain colaborador) {
		this.colaborador = colaborador;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getLinkFoto() {
		return linkFoto;
	}

	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}

	
	
	
	
	

	
	
}

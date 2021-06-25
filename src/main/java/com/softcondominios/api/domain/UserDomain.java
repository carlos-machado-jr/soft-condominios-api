package com.softcondominios.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.softcondominios.api.rest.dto.NewUserDto;

@Entity
public class UserDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String login;
	
	@Column
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "id_grupo")
	private GrupoPermissaoDomain grupoPermissao;
	
	@Column
	private boolean status;
	
	@Column
	private String linkFoto;
	
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

	public GrupoPermissaoDomain getGrupoPermissao() {
		return grupoPermissao;
	}

	public void setGrupoPermissao(GrupoPermissaoDomain grupoPermissao) {
		this.grupoPermissao = grupoPermissao;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((grupoPermissao == null) ? 0 : grupoPermissao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((linkFoto == null) ? 0 : linkFoto.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (status ? 1231 : 1237);
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
		UserDomain other = (UserDomain) obj;
		if (grupoPermissao == null) {
			if (other.grupoPermissao != null)
				return false;
		} else if (!grupoPermissao.equals(other.grupoPermissao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (linkFoto == null) {
			if (other.linkFoto != null)
				return false;
		} else if (!linkFoto.equals(other.linkFoto))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	
	

	
	
}

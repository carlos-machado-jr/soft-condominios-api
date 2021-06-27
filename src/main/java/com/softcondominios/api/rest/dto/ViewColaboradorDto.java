package com.softcondominios.api.rest.dto;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.domain.CondominioDomain;

public class ViewColaboradorDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	private String email;
	private String cpf;
	private String status;
	private String funcao;
	private Set<ViewCondominioDto> condominio;
	
	public ViewColaboradorDto() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ViewColaboradorDto(ColaboradorDomain colaborador) {
		super();
		this.nome = colaborador.getNome();
		this.sobrenome = colaborador.getSobrenome();
		this.email = colaborador.getEmail();
		this.cpf = colaborador.getCpf();
		this.status = colaborador.isStatus() ? "ativado" : "desativado";
		this.funcao = colaborador.getFuncao().getDescricao();
		this.condominio = convertDto(colaborador.getCondominio());
	}

	private Set<ViewCondominioDto> convertDto(Set<CondominioDomain> condominio) {
//		List<CondominioDomain> newCondominio = new ArrayList<CondominioDomain>(condominio);
		return  condominio.stream().map(c -> new ViewCondominioDto(c)).collect(Collectors.toSet()); 
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Set<ViewCondominioDto> getCondominio() {
		return condominio;
	}

	public void setCondominio(Set<ViewCondominioDto> condominio) {
		this.condominio = condominio;
	}
	
	
}

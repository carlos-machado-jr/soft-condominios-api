package com.softcondominios.api.rest.dto;

import java.io.Serializable;

import com.softcondominios.api.domain.CondominioDomain;

public class ViewCondominioDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String cep;
	private String rua;
	private String numero;
	private String razaoSocial;
	private String nomeFantazia;
	private String cnpj;
	private String linkContratoSocial;
	private String bairro;
	private String cidade;
	private String estado;
	
	
	public ViewCondominioDto() {
		// TODO Auto-generated constructor stub
	}
	
	



	public ViewCondominioDto(CondominioDomain condominio) {
		super();
		this.id = condominio.getId();
		this.cep = condominio.getCep();
		this.rua = condominio.getRua();
		this.numero = condominio.getNumero();
		this.razaoSocial = condominio.getRazaoSocial();
		this.nomeFantazia = condominio.getRazaoSocial();
		this.cnpj = condominio.getCnpj();
		this.linkContratoSocial = condominio.getLinkContratoSocial();
		this.bairro = condominio.getBairro().getDescricao();
		this.cidade = condominio.getBairro().getCidadeDomain().getDescricao();
		this.estado = condominio.getBairro().getCidadeDomain().getEstadoDomain().getUF();
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getNomeFantazia() {
		return nomeFantazia;
	}


	public void setNomeFantazia(String nomeFantazia) {
		this.nomeFantazia = nomeFantazia;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getLinkContratoSocial() {
		return linkContratoSocial;
	}


	public void setLinkContratoSocial(String linkContratoSocial) {
		this.linkContratoSocial = linkContratoSocial;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}

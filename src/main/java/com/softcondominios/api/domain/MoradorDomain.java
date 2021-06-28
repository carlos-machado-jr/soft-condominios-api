package com.softcondominios.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_morador")
public class MoradorDomain implements Serializable {

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
	
	@Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
	@NotNull
	private String apartamento;
	
	@Column(columnDefinition = "varchar(20)", nullable = false, unique = true)
	@NotNull
	private String bloco;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	@NotNull
	private boolean status;
	
	
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
//	chaves estrangeiras --------||||||><><><__-_
	
	@OneToMany
	@JoinColumn(name = "mor_con_id")
	private CondominioDomain condominio;
}

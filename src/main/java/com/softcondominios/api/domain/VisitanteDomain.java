package com.softcondominios.api.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.softcondominios.api.rest.dto.NewVisitanteDto;

@Entity
@Table(name = "tb_visitante")
public class VisitanteDomain implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String nome;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String sobrenome;
	
	@Column(columnDefinition = "varchar(20)", nullable = false)
	private String cpf;
	
	@Column(columnDefinition = "varchar(50)", nullable = false)
	private String tipoVisitante;
	
	@Column(columnDefinition = "varchar(20)")
	private String bloco;
	
	@Column(columnDefinition = "varchar(20)")
	private String apartamento;
	
	@Column(columnDefinition = "DATETIME")
	private String dataHoraEntrada;
	
	@Column(columnDefinition = "DATETIME")
	private String dataHoraSaida;
	
	@Column(columnDefinition = "varchar(250)")
	private String observacao;
	
	@Column(columnDefinition = "varchar(250)", nullable = false)
	private String nomePorteiro;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "vis_con_id")
	private CondominioDomain condominio;
	
	public VisitanteDomain() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public VisitanteDomain(NewVisitanteDto newVisitante, ColaboradorDomain colaborador, CondominioDomain condominio) {
		super();
		this.id = null;
		this.nome = newVisitante.getNome();
		this.sobrenome = newVisitante.getSobrenome();
		this.cpf = newVisitante.getCpf();
		this.tipoVisitante = newVisitante.getTipoVisitante();
		this.bloco = newVisitante.getBloco();
		this.apartamento = newVisitante.getApartamento();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		this.dataHoraEntrada = date.format(now);
		this.dataHoraSaida = null;
		this.observacao = newVisitante.getObservacao();
		this.nomePorteiro = colaborador.getNome() + " " + colaborador.getSobrenome();
		this.condominio = condominio;
		this.status = true;
	}
	
	public VisitanteDomain(NewVisitanteDto newVisitante, VisitanteDomain visitante) {
		super();
		this.id = visitante.getId();
		this.nome = Objects.isNull(newVisitante.getNome()) ? visitante.getNome() : newVisitante.getNome();
		this.sobrenome = Objects.isNull(newVisitante.getSobrenome()) ? visitante.getSobrenome() : newVisitante.getSobrenome();
		this.cpf = Objects.isNull(newVisitante.getCpf()) ? visitante.getNome() : newVisitante.getCpf();
		this.tipoVisitante = Objects.isNull(newVisitante.getTipoVisitante()) ? visitante.getTipoVisitante() : newVisitante.getTipoVisitante();
		this.bloco = Objects.isNull(newVisitante.getBloco()) ? visitante.getBloco() : newVisitante.getBloco();
		this.apartamento = Objects.isNull(newVisitante.getApartamento()) ? visitante.getApartamento() : newVisitante.getApartamento();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		this.dataHoraEntrada = visitante.getDataHoraEntrada();
		this.dataHoraSaida = newVisitante.isStatus() && Objects.nonNull(newVisitante.isStatus()) ? null : date.format(now);
		this.observacao = Objects.isNull(newVisitante.getObservacao()) ? visitante.getObservacao() : newVisitante.getObservacao();
		this.nomePorteiro = visitante.getNomePorteiro();
		this.condominio = visitante.getCondominio(); 
		this.status = Objects.isNull(newVisitante.isStatus()) ? visitante.isStatus() : newVisitante.isStatus();
	}
	




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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoVisitante() {
		return tipoVisitante;
	}

	public void setTipoVisitante(String tipoVisitante) {
		this.tipoVisitante = tipoVisitante;
	}

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getDataHoraEntrada() {
		return dataHoraEntrada;
	}

	public void setDataHoraEntrada(String dataHoraEntrada) {
		this.dataHoraEntrada = dataHoraEntrada;
	}

	public String getDataHoraSaida() {
		return dataHoraSaida;
	}

	public void setDataHoraSaida(String dataHoraSaida) {
		this.dataHoraSaida = dataHoraSaida;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getNomePorteiro() {
		return nomePorteiro;
	}

	public void setNomePorteiro(String nomePorteiro) {
		this.nomePorteiro = nomePorteiro;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}

	

	public CondominioDomain getCondominio() {
		return condominio;
	}




	public void setCondominio(CondominioDomain condominio) {
		this.condominio = condominio;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apartamento == null) ? 0 : apartamento.hashCode());
		result = prime * result + ((bloco == null) ? 0 : bloco.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataHoraEntrada == null) ? 0 : dataHoraEntrada.hashCode());
		result = prime * result + ((dataHoraSaida == null) ? 0 : dataHoraSaida.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nomePorteiro == null) ? 0 : nomePorteiro.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		result = prime * result + ((tipoVisitante == null) ? 0 : tipoVisitante.hashCode());
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
		VisitanteDomain other = (VisitanteDomain) obj;
		if (apartamento == null) {
			if (other.apartamento != null)
				return false;
		} else if (!apartamento.equals(other.apartamento))
			return false;
		if (bloco == null) {
			if (other.bloco != null)
				return false;
		} else if (!bloco.equals(other.bloco))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataHoraEntrada == null) {
			if (other.dataHoraEntrada != null)
				return false;
		} else if (!dataHoraEntrada.equals(other.dataHoraEntrada))
			return false;
		if (dataHoraSaida == null) {
			if (other.dataHoraSaida != null)
				return false;
		} else if (!dataHoraSaida.equals(other.dataHoraSaida))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nomePorteiro == null) {
			if (other.nomePorteiro != null)
				return false;
		} else if (!nomePorteiro.equals(other.nomePorteiro))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		if (status != other.status)
			return false;
		if (tipoVisitante == null) {
			if (other.tipoVisitante != null)
				return false;
		} else if (!tipoVisitante.equals(other.tipoVisitante))
			return false;
		return true;
	}

	

	

}

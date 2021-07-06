package com.softcondominios.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;

@Repository
public interface AgendamentoMudancaRepository extends JpaRepository<AgendamentoMudancaDomain, Long>, JpaSpecificationExecutor<AgendamentoMudancaDomain>{
	
	List<AgendamentoMudancaDomain> findByDataHora(String dataHora);
}

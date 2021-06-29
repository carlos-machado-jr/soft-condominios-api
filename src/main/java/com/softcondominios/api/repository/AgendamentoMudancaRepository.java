package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;

@Repository
public interface AgendamentoMudancaRepository extends JpaRepository<AgendamentoMudancaDomain, Long>{

}

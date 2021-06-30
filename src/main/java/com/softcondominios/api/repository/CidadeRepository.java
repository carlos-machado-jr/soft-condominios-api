package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.CidadeDomain;

@Repository
public interface CidadeRepository extends JpaRepository<CidadeDomain, Long>{

	CidadeDomain findByDescricao(String descricao);

}

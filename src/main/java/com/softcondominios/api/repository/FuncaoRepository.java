package com.softcondominios.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.FuncaoDomain;

@Repository
public interface FuncaoRepository extends JpaRepository<FuncaoDomain, Long> {

	Optional<FuncaoDomain> findByDescricao(String funcao);

	
	
}

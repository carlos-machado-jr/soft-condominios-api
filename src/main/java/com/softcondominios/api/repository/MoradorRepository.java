package com.softcondominios.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.MoradorDomain;

@Repository
public interface MoradorRepository extends JpaRepository<MoradorDomain, Long>, JpaSpecificationExecutor<MoradorDomain> {

	List<MoradorDomain> findByCondominio(CondominioDomain condominio);
	
	Optional<MoradorDomain> findByEmail(String email);
	
}

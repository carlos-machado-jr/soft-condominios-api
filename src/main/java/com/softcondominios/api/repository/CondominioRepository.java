package com.softcondominios.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.domain.CondominioDomain;

@Repository
public interface CondominioRepository extends JpaRepository<CondominioDomain, Long>{

	Optional<ColaboradorDomain> findByBairro(Long id);

}

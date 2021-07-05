package com.softcondominios.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.ColaboradorDomain;

@Repository
public interface ColaboradorRepository extends JpaRepository<ColaboradorDomain, Long>, JpaSpecificationExecutor<ColaboradorDomain> {

	Optional<ColaboradorDomain> findByEmail(String email);

}

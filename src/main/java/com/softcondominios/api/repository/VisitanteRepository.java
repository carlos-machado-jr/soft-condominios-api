package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.VisitanteDomain;

@Repository
public interface VisitanteRepository extends JpaRepository<VisitanteDomain, Long>, JpaSpecificationExecutor<VisitanteDomain> {

}

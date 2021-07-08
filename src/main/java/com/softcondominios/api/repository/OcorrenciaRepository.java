package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.OcorrenciaDomain;

@Repository
public interface OcorrenciaRepository extends JpaRepository<OcorrenciaDomain, Long> , JpaSpecificationExecutor<OcorrenciaDomain>{

}

package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.GrupoPermissaoDomain;

@Repository
public interface GrupoPermissaoRepository extends JpaRepository<GrupoPermissaoDomain, Long>{

}

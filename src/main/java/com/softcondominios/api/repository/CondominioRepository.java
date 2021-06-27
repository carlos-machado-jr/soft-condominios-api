package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.CondominioDomain;

@Repository
public interface CondominioRepository extends JpaRepository<CondominioDomain, Long>{

}

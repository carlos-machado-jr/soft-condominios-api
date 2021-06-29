package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.MoradorDomain;

@Repository
public interface MoradorRepository extends JpaRepository<MoradorDomain, Long> {

}

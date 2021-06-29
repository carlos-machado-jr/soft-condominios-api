package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.EncomendaDomain;

@Repository
public interface EncomendaRepository extends JpaRepository<EncomendaDomain, Long> {

}

package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.EstadoDomain;

@Repository
public interface EstadoRepository extends JpaRepository<EstadoDomain, Long>{


	EstadoDomain findByUF(String uf);

}

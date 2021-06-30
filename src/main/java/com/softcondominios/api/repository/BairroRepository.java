package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.BairroDomain;

@Repository
public interface BairroRepository extends JpaRepository<BairroDomain, Long>{

	BairroDomain findByDescricao(String descricao);

}

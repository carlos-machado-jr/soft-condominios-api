package com.softcondominios.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.BairroDomain;
import com.softcondominios.api.domain.CondominioDomain;

@Repository
public interface CondominioRepository extends JpaRepository<CondominioDomain, Long>, JpaSpecificationExecutor<CondominioDomain>{

	Optional<List<CondominioDomain>> findByBairro(BairroDomain bairro);

}

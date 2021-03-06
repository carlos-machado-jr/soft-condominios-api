package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.MensagemDomain;

@Repository
public interface MensagemRepository extends JpaRepository<MensagemDomain, Long> {

}

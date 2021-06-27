package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.repository.CondominioRepository;

@Service
public class CondominioService {
	@Autowired
	private CondominioRepository condominioRepository;
	
	
	public Page<CondominioDomain> findAll(Pageable pageable){
		return condominioRepository.findAll(pageable);
	}
	
	public CondominioDomain save(CondominioDomain condominioDomain) {
		return condominioRepository.save(condominioDomain);
	}
	
	
}

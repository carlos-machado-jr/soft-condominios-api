package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.EncomendaDomain;
import com.softcondominios.api.repository.EncomendaRepository;

@Service
public class EncomendaService {
	@Autowired
	private EncomendaRepository encomendaRepository;
	
	public Page<EncomendaDomain> findAll(Pageable pageable){
		return encomendaRepository.findAll(pageable);
	}
	
	public EncomendaDomain save(EncomendaDomain encomendaDomain) {
		return encomendaRepository.save(encomendaDomain);
	}

}

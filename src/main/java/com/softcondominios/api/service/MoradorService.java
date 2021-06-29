package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.repository.MoradorRepository;

@Service
public class MoradorService {

	@Autowired
	private MoradorRepository moradorRepository;
	
	public Page<MoradorDomain> findAll(Pageable pageable){
		return moradorRepository.findAll(pageable);
	}
	
	public MoradorDomain save(MoradorDomain moradorDomain) {
		return moradorRepository.save(moradorDomain);
	}
	
}

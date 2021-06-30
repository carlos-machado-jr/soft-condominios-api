package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.repository.CondominioRepository;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;

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
	
	public CondominioDomain findById(Long id) {
		return condominioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Condomiminio nao encontrado! Id: " + id + ", Tipo: " + CondominioDomain.class.getName()));
	}
	
}

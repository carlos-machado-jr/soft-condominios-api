package com.softcondominios.api.service;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	
	public Page<ColaboradorDomain> findAll(Pageable pageable){
		return colaboradorRepository.findAll(pageable);
	}
	
	public ColaboradorDomain save(ColaboradorDomain colaboradorDomain) {
		return colaboradorRepository.save(colaboradorDomain);
	}
	
	public ColaboradorDomain update(ColaboradorDomain colaboradorDomain) {
		return colaboradorRepository.save(colaboradorDomain);
	}

	public ColaboradorDomain findByEmail(String email) {
		return colaboradorRepository.findByEmail(email).orElseThrow(() -> objectNotFoundException("Email nao encontrado!"));
	}
	
	
	@Transactional
	private ObjectNotFoundException objectNotFoundException(String message) {
		return new ObjectNotFoundException(
				message, ColaboradorDomain.class.getName());
	}
}

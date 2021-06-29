package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.MensagemDomain;
import com.softcondominios.api.repository.MensagemRepository;

@Service
public class MensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	public Page<MensagemDomain> findAll(Pageable pageable){
		return mensagemRepository.findAll(pageable);
	}
	
	public MensagemDomain save(MensagemDomain mensagemDomain) {
		return mensagemRepository.save(mensagemDomain);
	}
}

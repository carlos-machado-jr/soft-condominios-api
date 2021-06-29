package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.OcorrenciaDomain;
import com.softcondominios.api.repository.OcorrenciaRepository;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	
	public Page<OcorrenciaDomain> findAll(Pageable pageable){
		return ocorrenciaRepository.findAll(pageable);
	}
	
	public OcorrenciaDomain save(OcorrenciaDomain ocorrenciaDomain) {
		return ocorrenciaRepository.save(ocorrenciaDomain);
	}
}


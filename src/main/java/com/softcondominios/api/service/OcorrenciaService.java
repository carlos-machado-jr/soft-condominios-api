package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.domain.OcorrenciaDomain;
import com.softcondominios.api.repository.OcorrenciaRepository;
import com.softcondominios.api.rest.dto.NewOcorrenciaDto;
import com.softcondominios.api.service.specifications.OcorrenciaServiceSpecifications;

@Service
public class OcorrenciaService extends OcorrenciaServiceSpecifications{

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private MoradorService moradorService;
	
	public Page<OcorrenciaDomain> findAll(Pageable pageable){
		return ocorrenciaRepository.findAll(pageable);
	}
	
	public Page<OcorrenciaDomain> search(Boolean status, Long condominio, Pageable pageable){
		return ocorrenciaRepository.findAll(searchBy(status, condominio), pageable);
	}
	
	
	public OcorrenciaDomain save(NewOcorrenciaDto newOcorrencia) {
		MoradorDomain morador = moradorService.findByMorador();
		OcorrenciaDomain ocorrencia = new OcorrenciaDomain(newOcorrencia, morador);
		
		
		return ocorrenciaRepository.save(ocorrencia);
	}
}


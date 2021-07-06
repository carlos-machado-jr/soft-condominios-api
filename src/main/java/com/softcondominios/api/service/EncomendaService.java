package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.EncomendaDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.repository.EncomendaRepository;
import com.softcondominios.api.rest.dto.NewEncomendasDto;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;

@Service
public class EncomendaService {
	@Autowired
	private EncomendaRepository encomendaRepository;
	
	@Autowired
	private MoradorService moradorService;
	
	public Page<EncomendaDomain> findAll(Pageable pageable){
		return encomendaRepository.findAll(pageable);
	}
	
	public EncomendaDomain save(NewEncomendasDto newEncomendas) {
		MoradorDomain morador = moradorService.findByMorador();
		EncomendaDomain encomendas = new EncomendaDomain(newEncomendas, morador);
		
		return encomendaRepository.save(encomendas);
	}
	
	public EncomendaDomain update(EncomendaDomain encomendaDomain) {
		EncomendaDomain newEncomenda = encomendaRepository.findById(encomendaDomain.getId()).orElseThrow(() -> 
									new ObjectNotFoundException("Encomenda nao encontrada! Id: " + encomendaDomain.getId() + ", Tipo: " + EncomendaDomain.class.getName()));
		return encomendaRepository.save(newEncomenda);
	}

}

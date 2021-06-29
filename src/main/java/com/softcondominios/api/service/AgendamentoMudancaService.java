package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;
import com.softcondominios.api.repository.AgendamentoMudancaRepository;

@Service
public class AgendamentoMudancaService {

	@Autowired
	private AgendamentoMudancaRepository agendamentoMudancaRepository;
	
	public Page<AgendamentoMudancaDomain> findAll(Pageable pageable){
		return agendamentoMudancaRepository.findAll(pageable);
	}
	
	public AgendamentoMudancaDomain save(AgendamentoMudancaDomain agendamentoMudancaDomain) {
		return agendamentoMudancaRepository.save(agendamentoMudancaDomain);
	}
	
}

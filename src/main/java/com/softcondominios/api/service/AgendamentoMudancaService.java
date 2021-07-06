package com.softcondominios.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.repository.AgendamentoMudancaRepository;
import com.softcondominios.api.rest.dto.NewAgendamentoMudancaDto;
import com.softcondominios.api.service.specifications.AgendamentoMudancaServiceSpecifications;

@Service
public class AgendamentoMudancaService extends AgendamentoMudancaServiceSpecifications{

	@Autowired
	private AgendamentoMudancaRepository agendamentoMudancaRepository;
	
	@Autowired
	private MoradorService moradorService;
	
	public Page<AgendamentoMudancaDomain> findAll(Pageable pageable){
		return agendamentoMudancaRepository.findAll(pageable);
	}
	
	public Page<AgendamentoMudancaDomain> search(Boolean status, Long condominio, Pageable pageable){
		return agendamentoMudancaRepository.findAll( searchBy(status, condominio) , pageable);
	}
	
	
	@Transactional
	public AgendamentoMudancaDomain save(NewAgendamentoMudancaDto agendamentoMudancaDto) {
		MoradorDomain morador = moradorService.findByMorador();
		AgendamentoMudancaDomain agendamento = new AgendamentoMudancaDomain(agendamentoMudancaDto, morador);
		return agendamentoMudancaRepository.save(agendamento);
	}
	
}

package com.softcondominios.api.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.repository.AgendamentoMudancaRepository;
import com.softcondominios.api.rest.dto.NewAgendamentoMudancaDto;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;
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
	
	public List<String> buscarHoraDisponivel(String data) throws ParseException{
		
		List<String> horas = List.of("09:00:00", "11:00:00", "13:00:00", "15:00:00", "17:00:00");
		List<AgendamentoMudancaDomain> agendamento = agendamentoMudancaRepository.findAll(searchByData(data));
		
		horas = eFimDeSemana(data) ? Arrays.asList("09:00:00", "11:00:00", "13:00:00") : horas;
		
		if(Objects.nonNull(agendamento)) {
			for(Iterator<AgendamentoMudancaDomain> iterator = agendamento.iterator(); iterator.hasNext();) {
				
				AgendamentoMudancaDomain a = (AgendamentoMudancaDomain) iterator.next();
				String[] datetime = a.getDataHora().split(" ");
				String horaAgendamento = datetime[1];
				horas = horas.stream().filter(x -> !x.contains(horaAgendamento)).collect(Collectors.toList());
			}
			
			
		}
		
		return horas;
	}
	
	public Page<AgendamentoMudancaDomain> search(Boolean status, Long condominio, Pageable pageable){
		return agendamentoMudancaRepository.findAll( searchBy(status, condominio) , pageable);
	}
	
	
	@Transactional
	public AgendamentoMudancaDomain save(NewAgendamentoMudancaDto agendamentoMudancaDto) {
		MoradorDomain morador = moradorService.findByMorador();
		String data = agendamentoMudancaDto.getData();
		String hora = agendamentoMudancaDto.getHora();
		
		
		AgendamentoMudancaDomain agendamento = new AgendamentoMudancaDomain(agendamentoMudancaDto, morador);
		
		List<AgendamentoMudancaDomain> verifyMudanca = agendamentoMudancaRepository.findByDataHora(agendamento.getDataHora());
	
		if(verifyMudanca.isEmpty()) {
			if(horarioNaoPermitido(data, hora)) {
			return agendamentoMudancaRepository.save(agendamento);
			
			} else { 
				throw new ObjectNotFoundException("Horario não disponivel em fim de semanas " + AgendamentoMudancaDomain.class.getName());
				}
			
		} else {
			 throw new ObjectNotFoundException("Horario ja cadastrado " + AgendamentoMudancaDomain.class.getName());
		}
		
	}
	
	private Boolean eFimDeSemana(String data) {
		try {
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(parser.parse(data));
			return cal.get(Calendar.DAY_OF_WEEK) == 6 || cal.get(Calendar.DAY_OF_WEEK) == 7;
		} catch (ParseException e) {
			throw new ObjectNotFoundException("erro ao pegar data");
		}
		
	}
	
	private Boolean horarioNaoPermitido(String data, String hora) {
		List<String> horas =  Arrays.asList("15:00:00", "17:00:00");
		if(eFimDeSemana(data)){
			return horas.contains(hora) ? false : true;
		}
		return true;
	}
}

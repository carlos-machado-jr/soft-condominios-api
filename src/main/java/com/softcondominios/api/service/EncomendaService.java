package com.softcondominios.api.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.EncomendaDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.repository.EncomendaRepository;
import com.softcondominios.api.rest.dto.NewEncomendasDto;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;
import com.softcondominios.api.service.specifications.EncomendaServiceEspecifications;

@Service
public class EncomendaService extends EncomendaServiceEspecifications{
	@Autowired
	private EncomendaRepository encomendaRepository;
	
	@Autowired
	private MoradorService moradorService;
	
	public Page<EncomendaDomain> findAll(Pageable pageable){
		return encomendaRepository.findAll(pageable);
	}
	
	public Page<EncomendaDomain> search(Boolean status, Pageable pageable){
		return encomendaRepository.findAll(searchBy(status), pageable);
	}
	
	public EncomendaDomain save(NewEncomendasDto newEncomendas) {
		MoradorDomain morador = moradorService.findById(newEncomendas.getDestinatario());
		EncomendaDomain encomendas = new EncomendaDomain(newEncomendas, morador);
		
		return encomendaRepository.save(encomendas);
	}
	
	public EncomendaDomain update(NewEncomendasDto newEncomendasDto, Long id) {
		MoradorDomain morador = moradorService.findById(newEncomendasDto.getDestinatario());
		
		return encomendaRepository.save(updateEncomenda(newEncomendasDto, morador, id));
	}
	
	
	
	
	private  EncomendaDomain updateEncomenda(NewEncomendasDto newEncomendasDto, MoradorDomain morador, Long id) {
		EncomendaDomain encomenda = encomendaRepository.findById(id).orElseThrow(() -> 
		new ObjectNotFoundException("Encomenda nao encontrada! Id: " + id + ", Tipo: " + EncomendaDomain.class.getName()));
		
		encomenda.setDescricao(newEncomendasDto.getDescricao());
		encomenda.setDestinatario(morador.getNome() + " " + morador.getSobrenome());
		encomenda.setMorador(morador);
		encomenda.setApartamento(morador.getApartamento());
		encomenda.setBloco(morador.getBloco());
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		encomenda.setStatus(newEncomendasDto.getStatus());
		encomenda.setDataEntrega(encomenda.isStatus() ? date.format(now) : null);
		encomenda.setDataModificacao(encomenda.isStatus() ? null : date.format(now));
		return encomenda;
	}

}

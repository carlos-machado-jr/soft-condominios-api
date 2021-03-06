package com.softcondominios.api.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.ColaboradorDomain;
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
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	public Page<EncomendaDomain> findAll(Pageable pageable){
		return encomendaRepository.findAll(pageable);
	}
	
	@Transactional
	public Page<EncomendaDomain> search(Boolean status, Long condominio, Pageable pageable){
		return encomendaRepository.findAll(searchBy(status, condominio), pageable);
	}
	
	@Transactional
	public Page<EncomendaDomain> searchByMorador(Boolean status, Long condominio, Pageable pageable){
		MoradorDomain morador = moradorService.findByMorador();
		return encomendaRepository.findAll(searchBy(status, condominio, morador), pageable);
	}
	
	public EncomendaDomain save(NewEncomendasDto newEncomendas) {
		ColaboradorDomain colaborador = colaboradorService.findByColaborador();
		String autor = colaborador.getNome() + " " + colaborador.getSobrenome();
		MoradorDomain morador = moradorService.findById(newEncomendas.getDestinatario());
		EncomendaDomain encomendas = new EncomendaDomain(newEncomendas, morador, autor);
		
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

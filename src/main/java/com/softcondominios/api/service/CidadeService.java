package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.CidadeDomain;
import com.softcondominios.api.repository.CidadeRepository;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	
	
	public Page<CidadeDomain> findAll(Pageable pageable) {
		return cidadeRepository.findAll(pageable);
	}
	
	public CidadeDomain save(CidadeDomain cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public CidadeDomain update(CidadeDomain cidade) {
		return cidadeRepository.save(cidade);
	}
	
	public CidadeDomain findById(Long id) {
		return cidadeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cidade nao encontrada! cidade: " + id + ", Tipo: " + CidadeDomain.class.getName()));
	}
	public CidadeDomain findByDescricao(String descricao) {
		return cidadeRepository.findByDescricao(descricao);
	}
}

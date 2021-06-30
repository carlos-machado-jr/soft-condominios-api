package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.BairroDomain;
import com.softcondominios.api.repository.BairroRepository;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;

@Service
public class BairroService {
	
	@Autowired
	private BairroRepository bairroRepository;
	
	
	
	public Page<BairroDomain> findAll(Pageable pageable) {
		return bairroRepository.findAll(pageable);
	}
	
	public BairroDomain save(BairroDomain bairro) {
		return bairroRepository.save(bairro);
	}
	
	public BairroDomain update(BairroDomain bairro) {
		return bairroRepository.save(bairro);
	}
	
	public BairroDomain findById(Long id) {
		return bairroRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Bairro nao encontrado! bairro: " + id + ", Tipo: " + BairroDomain.class.getName()));
	}
	
	public BairroDomain findByDescricao(String descricao) {
		return bairroRepository.findByDescricao(descricao);
	}
}

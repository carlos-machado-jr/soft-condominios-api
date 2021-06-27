package com.softcondominios.api.service;


import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.FuncaoDomain;
import com.softcondominios.api.repository.FuncaoRepository;



@Service
public class FuncaoService {
	
	@Autowired
	private FuncaoRepository funcaoRepository;
	
	
	public Page<FuncaoDomain> findAll(Pageable pageable){
		return funcaoRepository.findAll(pageable);
	}
	
	public FuncaoDomain save(FuncaoDomain funcaoDomain) {
		return funcaoRepository.save(funcaoDomain);
	}
	
	public FuncaoDomain findByFuncao(String funcao) {
		return funcaoRepository.findByDescricao(funcao).orElseThrow(() -> objectNotFoundException("Funcao não encontrada!"));
	}
	
	
	@Transactional
	private ObjectNotFoundException objectNotFoundException(String message) {
		return new ObjectNotFoundException(
				message, FuncaoDomain.class.getName());
	}
}

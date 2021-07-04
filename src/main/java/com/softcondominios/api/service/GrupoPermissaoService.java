package com.softcondominios.api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.repository.GrupoPermissaoRepository;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;

@Service
public class GrupoPermissaoService {

	@Autowired
	GrupoPermissaoRepository grupoPermissaoRepository;
	
	public Page<GrupoPermissaoDomain> findAll(Pageable pageable){
		
		return grupoPermissaoRepository.findAll(pageable);
	}
	
	
	public GrupoPermissaoDomain findByDescricao(String descricao) {
		try {
			return grupoPermissaoRepository.findByDescricao(descricao);
			
		} catch (ObjectNotFoundException e) {
			
			throw new ObjectNotFoundException("Permissão nao encontrada! permissão: " + descricao + ", Tipo: " + GrupoPermissaoDomain.class.getName());
		}
		
				
				
	}
	
	public GrupoPermissaoDomain save(GrupoPermissaoDomain g) {
		return grupoPermissaoRepository.save(g);
	}
	

}

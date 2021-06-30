package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.EstadoDomain;
import com.softcondominios.api.repository.EstadoRepository;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	
	public Page<EstadoDomain> findAll(Pageable pageable) {
		return estadoRepository.findAll(pageable);
	}
	
	public EstadoDomain save(EstadoDomain estado) {
		return estadoRepository.save(estado);
	}
	
	public EstadoDomain update(EstadoDomain estado) {
		return estadoRepository.save(estado);
	}
	
	public EstadoDomain findById(Long id) {
		return estadoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Estado nao encontrada! estado: " + id + ", Tipo: " + EstadoDomain.class.getName()));
	}
	
	public EstadoDomain findByUF(String uf) {
		return estadoRepository.findByUF(uf);
	}
}

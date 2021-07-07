package com.softcondominios.api.service;

import java.util.Iterator;
import java.util.Objects;

import javax.persistence.Column;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.VisitanteDomain;
import com.softcondominios.api.repository.VisitanteRepository;
import com.softcondominios.api.rest.dto.NewVisitanteDto;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;
import com.softcondominios.api.service.specifications.VisitanteServiceSpecifications;

@Service
public class VisitanteService extends VisitanteServiceSpecifications{

	@Autowired
	private VisitanteRepository visitanteRepository;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	public Page<VisitanteDomain> findAll(Pageable pageable){
		return visitanteRepository.findAll(pageable);
	}
	
	public Page<VisitanteDomain> search(Boolean status, Long condominio, Pageable pageable){
		return visitanteRepository.findAll(searchBy(status, condominio), pageable);
	}
	
	public VisitanteDomain findById(Long id) {
		return visitanteRepository.findById(id).orElseThrow(() -> 
						new ObjectNotFoundException("visitante não encontrado!! id:" + id + " classe:" + VisitanteDomain.class.getName()));
	}
	
	@Transactional
	public VisitanteDomain save(NewVisitanteDto newVisitanteDto) {
		ColaboradorDomain colaborador = colaboradorService.findByColaborador();
		CondominioDomain condominio = new CondominioDomain();
		
		for(Iterator<CondominioDomain> i = colaborador.getCondominio().iterator(); i.hasNext();  ) {
			
			CondominioDomain c = (CondominioDomain) i.next();
			if(c.getId().equals(newVisitanteDto.getCondominio())) {
				condominio = c;
			}
			 
		}
		
		if(Objects.isNull(condominio)) {
			throw new ObjectNotFoundException("Porteiro ou zelador não estão nesse condominio! ");
		}
		
		VisitanteDomain visitante = new VisitanteDomain(newVisitanteDto, colaborador, condominio);
		
		return visitanteRepository.save(visitante);
		
		
	}
	
	public VisitanteDomain update(NewVisitanteDto newVisitanteDto, Long id) {
		VisitanteDomain visitante = new VisitanteDomain(newVisitanteDto, findById(id));
		return visitanteRepository.save(visitante);
	}
	

	


	
	@Column(columnDefinition = "varchar(250)")
	private String observacao;
	
	@Column(columnDefinition = "varchar(20)", nullable = false)
	private String nomePorteiro;
	
	@Column(columnDefinition = "tinyint", nullable = false)
	private boolean status;
	
}

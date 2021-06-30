package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.BairroDomain;
import com.softcondominios.api.domain.CidadeDomain;
import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.EstadoDomain;
import com.softcondominios.api.repository.ColaboradorRepository;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	

	@Autowired
	private BairroService bairroService;

	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	
	public Page<ColaboradorDomain> findAll(Pageable pageable){
		
		Page<ColaboradorDomain> colaborador = colaboradorRepository.findAll(pageable);
		colaborador.getContent().forEach(c -> {
			c.getCondominio().forEach(condominio -> {
				setByBairro(condominio);
				setByCidade(condominio);
				setByEstado(condominio);
				
			});
		});
		
		return colaborador;
	}
	
	public ColaboradorDomain save(ColaboradorDomain colaboradorDomain) {
		return colaboradorRepository.save(colaboradorDomain);
	}
	
	public ColaboradorDomain update(ColaboradorDomain colaboradorDomain) {
		return colaboradorRepository.save(colaboradorDomain);
	}

	public ColaboradorDomain findByEmail(String email) {
		return colaboradorRepository.findByEmail(email).orElseThrow(() -> 
					new ObjectNotFoundException("Email nao encontrado! email: " + email + ", Tipo: " + ColaboradorDomain.class.getName()));
	}
	
	private void setByBairro(CondominioDomain object){
		BairroDomain bairro = bairroService.findById(object.getBairro().getId()); 
		object.setBairro(bairro);
	}
	
	private void setByCidade(CondominioDomain object){
		CidadeDomain cidade = cidadeService.findById(object.getBairro().getCidadeDomain().getId()); 
		object.getBairro().setCidadeDomain(cidade);
	}
	
	private void setByEstado(CondominioDomain object){
		EstadoDomain estado = estadoService.findById(object.getBairro().getCidadeDomain().getId()); 
		object.getBairro().getCidadeDomain().setEstadoDomain(estado);
	}

	
}

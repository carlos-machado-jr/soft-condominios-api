package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.repository.ColaboradorRepository;
import com.softcondominios.api.rest.dto.NewColaboradorDto;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;
import com.softcondominios.api.service.specifications.ColaboradorServiceSpecifications;

@Service
public class ColaboradorService extends ColaboradorServiceSpecifications{
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private UserService userService;
	
	
	public Page<ColaboradorDomain> findAll(Pageable pageable){
		
		return colaboradorRepository.findAll(pageable);

	}
	
	public Page<ColaboradorDomain> search(String email,Pageable pageable){
		
		return colaboradorRepository.findAll(searchBy(email), pageable);

	}

	public ColaboradorDomain findByColaborador() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		auth.getAuthorities().contains(new SimpleGrantedAuthority("SINDICO"));
		
		
		return colaboradorRepository.findByEmail(auth.getName()).orElseThrow(() -> 
		new ObjectNotFoundException("Colaborador nao encontrado! email: " + auth.getName() + ", Tipo: " + ColaboradorDomain.class.getName()));
	}
	
	public ColaboradorDomain save(NewColaboradorDto newColaborador) {
		return colaboradorRepository.save(convertToDomain(newColaborador));
	}
	
//	public ColaboradorDomain update(ColaboradorDomain colaboradorDomain) {
//		return colaboradorRepository.save(colaboradorDomain);
//	}


	private ColaboradorDomain convertToDomain(NewColaboradorDto newColaborador) {
		ColaboradorDomain colaborador = new ColaboradorDomain(newColaborador);
		colaborador.setUsuario(userService.save(newColaborador));
		return colaborador;
	}


	
}

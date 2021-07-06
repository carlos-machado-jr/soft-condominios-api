package com.softcondominios.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.domain.CondominioDomain;
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
	
	@Autowired
	private CondominioService condominioService;
	
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
	
	public ColaboradorDomain saveSindico(NewColaboradorDto newColaborador) {
		ColaboradorDomain colaborador = convertToDomain(newColaborador);
		colaborador.setFuncao("Sindico");
		colaborador.setUsuario(userService.save(newColaborador));
		return colaboradorRepository.save(colaborador);
	}
	
	public ColaboradorDomain saveFuncionarios(NewColaboradorDto newColaborador) {
		
		ColaboradorDomain colaborador = convertToDomain(newColaborador);
		CondominioDomain condominio = condominioService.findById(newColaborador.getCondominio());
		colaborador.setCondominio(convertByHashSet(condominio));
		colaborador.setUsuario(userService.save(newColaborador));
		return colaboradorRepository.save(colaborador);
	}
	
	
	public ColaboradorDomain update(ColaboradorDomain colaboradorDomain) {
		return colaboradorRepository.save(colaboradorDomain);
	}


	private ColaboradorDomain convertToDomain(NewColaboradorDto newColaborador) {
		ColaboradorDomain colaborador = new ColaboradorDomain(newColaborador);
		
		return colaborador;
	}

	private Set<CondominioDomain> convertByHashSet(CondominioDomain condominio){
		Set<CondominioDomain> condominioSet = new HashSet<CondominioDomain>();
		condominioSet.add(condominio);
		return condominioSet;
	}

	
}

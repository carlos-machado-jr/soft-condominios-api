package com.softcondominios.api.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.repository.UserRepository;
import com.softcondominios.api.rest.dto.NewColaboradorDto;
import com.softcondominios.api.security.UserSS;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private GrupoPermissaoService grupoPermissaoService;
	
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public Page<UserDomain> findAll(Pageable page){ 
//		 
        return userRepository.findAll(page);
        
	}
	
	public UserDomain save(UserDomain user) {
		return userRepository.save(user);
	}
	
	public UserDomain save(NewColaboradorDto newColaborador) {
		
		UserDomain user = new UserDomain(newColaborador);
		user.setGrupoPermissao(findGruposByDescricao(newColaborador.getFuncao()));
		user.setPassword(criptografarSenha(user.getPassword()));
		return userRepository.save(user);
	}
	
	private String criptografarSenha(String senha) {
		return bCryptPasswordEncoder.encode(senha);
	}
	
	private Set<GrupoPermissaoDomain> findGruposByDescricao(String descricao) {
		
		return Set.of(grupoPermissaoService.findByDescricao(descricao));
	}
	
	
	
}

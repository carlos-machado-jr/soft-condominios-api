package com.softcondominios.api.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.repository.UserRepository;
import com.softcondominios.api.rest.dto.NewColaboradorDto;
import com.softcondominios.api.rest.dto.ViewColaboradorDto;
import com.softcondominios.api.rest.dto.ViewMoradorDto;
import com.softcondominios.api.security.UserSS;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;
import com.softcondominios.api.service.specifications.UserServiceSpecifications;

@Service
public class UserService extends UserServiceSpecifications{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private GrupoPermissaoService grupoPermissaoService;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private MoradorService moradorService;
	
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
	
//	public List<UserDomain> findAll(Set<CondominioDomain> condominio, MoradorDomain morador){ 
//       if(Objects.nonNull(findUser().getColaborador())) {
//    	   return userRepository.findAll(searchBy(true, condominio, findUser().getColaborador().getFuncao() , morador));
//       }
//       return userRepository.findAll(searchBy(true, condominio,"Morador" , morador));
//       
//	}
	
	public UserDomain save(UserDomain user) {
		return userRepository.save(user);
	}
	
	public UserDomain save(NewColaboradorDto newColaborador) {
		
		UserDomain user = new UserDomain(newColaborador);
		user.setGrupoPermissao(findGruposByDescricao(newColaborador.getFuncao()));
		user.setPassword(criptografarSenha(user.getPassword()));
		return userRepository.save(user);
	}
	
	public Object findUserAuth() {
		
		if(hasRole( "ADMINISTRADOR")) {
			return null;
		}
		if(hasRole( "MORADOR")) {
			return new ViewMoradorDto(moradorService.findByMorador());
		}
		
		return  new ViewColaboradorDto(colaboradorService.findByColaborador());
	}
	
	public UserDomain findUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			
		
		return userRepository.findByLogin(auth.getName()).orElseThrow(() -> 
		new ObjectNotFoundException("Usuario nao encontrado! email: " + auth.getName() + ", Tipo: " + UserDomain.class.getName()));
	}
	
	private boolean hasRole( String role) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getAuthorities().contains(new SimpleGrantedAuthority(role));
	}
	
	private String criptografarSenha(String senha) {
		return bCryptPasswordEncoder.encode(senha);
	}
	
	private Set<GrupoPermissaoDomain> findGruposByDescricao(String descricao) {
		
		return convertByHashSet(grupoPermissaoService.findByDescricao(descricao));

	}
	
	private Set<GrupoPermissaoDomain> convertByHashSet(GrupoPermissaoDomain grupoPermissaoDomain){
		Set<GrupoPermissaoDomain> permissao = new HashSet<GrupoPermissaoDomain>();
		permissao.add(grupoPermissaoDomain);
		return permissao;
	}
	
}

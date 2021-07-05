package com.softcondominios.api.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.repository.UserRepository;
import com.softcondominios.api.security.UserSS;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repo;
	
	@Transactional
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserDomain userDomain = repo.findByLogin(login).orElseThrow( () -> new UsernameNotFoundException("Usuario não encontrado"));
		if (userDomain == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UserSS(userDomain.getId(),userDomain.getLogin(), userDomain.getPassword(), userDomain.getGrupoPermissao());
	}
}

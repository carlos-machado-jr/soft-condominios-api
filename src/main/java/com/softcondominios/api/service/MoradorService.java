package com.softcondominios.api.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.repository.MoradorRepository;
import com.softcondominios.api.repository.UserRepository;
import com.softcondominios.api.rest.dto.NewMoradorDto;
import com.softcondominios.api.service.exceptions.DataIntegrityException;
import com.softcondominios.api.service.specifications.MoradorServiceSpecifications;

@Service
public class MoradorService extends MoradorServiceSpecifications{

	@Autowired
	private MoradorRepository moradorRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private GrupoPermissaoService grupoPermissaoService;
	
	@Autowired
	private CondominioService condominioService;
	
	public Page<MoradorDomain> findAll(Pageable pageable){
		return moradorRepository.findAll(pageable);
	}
	
	public Page<MoradorDomain> search(Long condominio, String nome, Pageable pageable){
		
		return moradorRepository.findAll(search(condominio,nome), pageable);
	}
	
	@Transactional
	public MoradorDomain save( NewMoradorDto newMoradorDto, Long id) {
		try {
			MoradorDomain morador = new MoradorDomain(newMoradorDto);
			morador.setCondominio(condominioService.findById(id));
			morador.setUsuario(createUser(newMoradorDto));
			
			return moradorRepository.save(morador);
		} catch (Exception e) {
			throw new DataIntegrityException("Exceção: " + e);
		}
	}
	
	

	private UserDomain createUser(NewMoradorDto newMoradorDto) {
		
		UserDomain user = new UserDomain(newMoradorDto);
		user.setGrupoPermissao(findByGruposDescricao("Morador"));
		user.setPassword(criptografarSenha(user.getPassword()));
		
		return userRepository.save(user);
		
	}
	
	private String criptografarSenha(String senha) {
		return bCryptPasswordEncoder.encode(senha);
	}
	
	private Set<GrupoPermissaoDomain> findByGruposDescricao(String descricao) {
		
		return convertByHashSet(grupoPermissaoService.findByDescricao(descricao));
	}
	
	private Set<GrupoPermissaoDomain> convertByHashSet(GrupoPermissaoDomain grupoPermissaoDomain){
		Set<GrupoPermissaoDomain> permissao = new HashSet<GrupoPermissaoDomain>();
		permissao.add(grupoPermissaoDomain);
		return permissao;
	}
}

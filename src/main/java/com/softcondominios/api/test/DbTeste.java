package com.softcondominios.api.test;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.repository.GrupoPermissaoRepository;

@Service
public class DbTeste {
	
	@Autowired
	private GrupoPermissaoRepository grupoPermissaoRepository;
	
	public void criarPermissoes() throws ParseException {
		if (grupoPermissaoRepository.findByDescricao("Administrador") == null) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Administrador");
			grupoPermissaoRepository.save(permissao);
		}
		if (grupoPermissaoRepository.findByDescricao("Sindico") == null) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Sindico");
			grupoPermissaoRepository.save(permissao);
		}
		if (grupoPermissaoRepository.findByDescricao("Zelador") == null) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Zelador");
			grupoPermissaoRepository.save(permissao);
		}
		if (grupoPermissaoRepository.findByDescricao("Porteiro") == null) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Porteiro");
			grupoPermissaoRepository.save(permissao);
		}
		if (grupoPermissaoRepository.findByDescricao("Morador") == null) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Morador");
			grupoPermissaoRepository.save(permissao);
		}
	
		
	}

}

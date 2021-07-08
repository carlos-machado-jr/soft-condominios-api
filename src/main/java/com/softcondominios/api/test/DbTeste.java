package com.softcondominios.api.test;

import java.text.ParseException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.repository.GrupoPermissaoRepository;

@Service
public class DbTeste {
	
	@Autowired
	private GrupoPermissaoRepository grupoPermissaoRepository;
	
	public void criarPermissoes() throws ParseException {
		if (Objects.isNull(grupoPermissaoRepository.findByDescricao("Administrador"))) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Administrador");
			grupoPermissaoRepository.save(permissao);
		}
		if (Objects.isNull(grupoPermissaoRepository.findByDescricao("Sindico"))) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Sindico");
			grupoPermissaoRepository.save(permissao);
		}
		if (Objects.isNull(grupoPermissaoRepository.findByDescricao("Zelador"))) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Zelador");
			grupoPermissaoRepository.save(permissao);
		}
		if (Objects.isNull(grupoPermissaoRepository.findByDescricao("Porteiro"))) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Porteiro");
			grupoPermissaoRepository.save(permissao);
		}
		if (Objects.isNull(grupoPermissaoRepository.findByDescricao("Morador"))) {
			GrupoPermissaoDomain permissao = new GrupoPermissaoDomain("Morador");
			grupoPermissaoRepository.save(permissao);
		}
//ssssssss	
		
	}

}

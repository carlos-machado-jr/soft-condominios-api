package com.softcondominios.api.test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.repository.GrupoPermissaoRepository;

@Service
public class DbTeste {
	
	@Autowired
	private GrupoPermissaoRepository grupoPermissaoRepository;
	
	public void criarPermissoes() throws ParseException {
//		GrupoPermissaoDomain p1 = new GrupoPermissaoDomain("Administrador");
//		GrupoPermissaoDomain p2 = new GrupoPermissaoDomain("Sindico");
//		GrupoPermissaoDomain p3 = new GrupoPermissaoDomain("Zelador");
//		GrupoPermissaoDomain p4 = new GrupoPermissaoDomain("Porteiro");
//		GrupoPermissaoDomain p5 = new GrupoPermissaoDomain("Morador");
//		List<GrupoPermissaoDomain> grp = Arrays.asList(p1,p2,p3,p4,p5);
//		grupoPermissaoRepository.findAll(grp);
		
	}

}

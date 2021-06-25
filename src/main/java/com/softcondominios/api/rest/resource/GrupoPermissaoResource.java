package com.softcondominios.api.rest.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.service.GrupoPermissaoService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/grupos-permissoes")
public class GrupoPermissaoResource {
	
	@Autowired
	private GrupoPermissaoService grupoPermissaoService;
	
	@ApiOperation("Retorna uma lista de grupos e permissoes")
	@GetMapping
	public ResponseEntity<Page<GrupoPermissaoDomain>> findAll(Pageable pageable){
		Page<GrupoPermissaoDomain> grupoPermissao = grupoPermissaoService.findAll(pageable);
		return ResponseEntity.ok(grupoPermissao);
		
	}
	
	
	
	@ApiOperation("Cria um grupo")
	@PostMapping
	public ResponseEntity<GrupoPermissaoDomain> save(@RequestBody GrupoPermissaoDomain grupoPermissaoDomain){
		
		GrupoPermissaoDomain g = grupoPermissaoService.save(grupoPermissaoDomain);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(g.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
}

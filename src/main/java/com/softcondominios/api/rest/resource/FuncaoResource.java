package com.softcondominios.api.rest.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.FuncaoDomain;
import com.softcondominios.api.service.FuncaoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/funcoes-colaboradores")
@Api("API Rest funcao")
@CrossOrigin(origins = "*")
public class FuncaoResource {
	
	@Autowired
	private FuncaoService funcaoService;
	
	@ApiOperation("Retorna uma lista de funcoes dos colaboradores")
	@GetMapping
	public ResponseEntity<Page<FuncaoDomain>> findAll(Pageable page){
			
		
		Page<FuncaoDomain> funcaoDomain = funcaoService.findAll(page);
		return ResponseEntity.ok(funcaoDomain); 
	
	}
	
	@ApiOperation("Cria uma funcao para os colaboradores")
	@PostMapping
	public ResponseEntity<FuncaoDomain> save(@RequestBody FuncaoDomain funcao){
		
		FuncaoDomain funcaoDomain = funcaoService.save(funcao);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(funcaoDomain.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

package com.softcondominios.api.rest.resource;

import java.net.URI;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.service.ColaboradorService;
import com.softcondominios.api.service.CondominioService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/condominios")
@Api("API Rest condominios")
@CrossOrigin(origins = "*")
public class CondominioResource {

	@Autowired
	private CondominioService condominioService;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	
	@ApiOperation(value = "Retorna uma lista de condominios")
	@Transactional
	@GetMapping
	public ResponseEntity<Page<CondominioDomain>> findAll(Pageable page){
			
		
		Page<CondominioDomain> condominio = condominioService.findAll(page);
		
		return ResponseEntity.ok(condominio); 
	
	}
	
	
	@ApiOperation("Cria um condominio")
	@PostMapping
	public ResponseEntity<CondominioDomain> save(@RequestBody CondominioDomain condominioDomain){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ColaboradorDomain colaborador = colaboradorService.findByEmail(auth.getName());
		
		CondominioDomain condominio = condominioService.save(condominioDomain);
		colaborador.getCondominio().add(condominio);
		colaboradorService.update(colaborador);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(condominio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

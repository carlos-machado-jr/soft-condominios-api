package com.softcondominios.api.rest.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.rest.dto.NewMoradorDto;
import com.softcondominios.api.rest.dto.ViewMoradorDto;
import com.softcondominios.api.service.MoradorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/moradores")
@Api("API Rest moradores")
@CrossOrigin(origins = "*")
public class MoradorResource {
	@Autowired
	private MoradorService moradorService;
	
	
	@ApiOperation("Retorna uma lista de moradores")
	@GetMapping
	public ResponseEntity<Page<ViewMoradorDto>> findAll(Pageable page){
			
		
		Page<ViewMoradorDto> moradorDto = convertDto(moradorService.findAll(page).getContent());
		return ResponseEntity.ok(moradorDto); 
	
	}
	
	
	@ApiOperation("Cria moradores")
	@PostMapping
	public ResponseEntity<NewMoradorDto> save(@Valid @RequestBody NewMoradorDto morador, @RequestParam Long condominioId){
		
		MoradorDomain moradorDomain = moradorService.save(morador, condominioId);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(moradorDomain.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
	private Page<ViewMoradorDto> convertDto(List<MoradorDomain> morador) {
		return new PageImpl<>(morador.stream().map(c -> new ViewMoradorDto(c)).collect(Collectors.toList())); 
	}
	
	@Transactional
	private ObjectNotFoundException objectNotFoundException(String message) {
		return new ObjectNotFoundException(
				message, CondominioDomain.class.getName());
	}
}

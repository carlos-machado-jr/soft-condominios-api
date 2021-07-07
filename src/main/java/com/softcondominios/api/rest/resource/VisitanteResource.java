package com.softcondominios.api.rest.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.VisitanteDomain;
import com.softcondominios.api.rest.dto.NewVisitanteDto;
import com.softcondominios.api.rest.dto.ViewVisitanteDto;
import com.softcondominios.api.service.VisitanteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/visitantes")
public class VisitanteResource {

	@Autowired
	private VisitanteService visitanteService;
	
	

	@ApiOperation("buscar todas os visitantes")
	@GetMapping
	public ResponseEntity<Page<ViewVisitanteDto>> findAll(Pageable pageable){
		return ResponseEntity.ok(convertDto(visitanteService.findAll(pageable).getContent()));
	}
	
	@ApiOperation("Busca dinamica")
	@GetMapping("/search")
	public ResponseEntity<Page<ViewVisitanteDto>> findAll(@RequestParam(required = false) Boolean status,
														   @RequestParam(required = false) Long condominio,			
												           Pageable pageable){
		return ResponseEntity.ok(convertDto(visitanteService.search(status, condominio, pageable).getContent()));
	}
	
	
	@ApiOperation("Cria uma visitante")
	@PostMapping
	public ResponseEntity<VisitanteDomain> save(@RequestBody NewVisitanteDto visitante){
		
		VisitanteDomain v = visitanteService.save(visitante);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(v.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@ApiOperation("Edita um visitante")
	@PutMapping("/{id}")
	public ResponseEntity<VisitanteDomain> update(@PathVariable Long id, @RequestBody NewVisitanteDto newVisitanteDto){
		
		visitanteService.update(newVisitanteDto, id);
		return ResponseEntity.noContent().build();
		
	}
	
	
	
	
	private Page<ViewVisitanteDto> convertDto(List<VisitanteDomain> encomenda) {
		return new PageImpl<>(encomenda.stream().map(c -> new ViewVisitanteDto(c)).collect(Collectors.toList())); 
	}
}

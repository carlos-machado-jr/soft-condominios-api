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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.EncomendaDomain;
import com.softcondominios.api.rest.dto.NewEncomendasDto;
import com.softcondominios.api.rest.dto.ViewEncomendasDto;
import com.softcondominios.api.service.EncomendaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/encomendas")
public class EncomendaResource {

	@Autowired
	private EncomendaService encomendaService;
	
	@GetMapping
	public ResponseEntity<Page<ViewEncomendasDto>> findAll(Pageable pageable){
		return ResponseEntity.ok(convertDto(encomendaService.findAll(pageable).getContent()));
	}
	
	
	@ApiOperation("Cria uma encomenda")
	@PostMapping
	public ResponseEntity<EncomendaDomain> save(@RequestBody NewEncomendasDto encomenda){
		
		EncomendaDomain e = encomendaService.save(encomenda);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(e.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@ApiOperation("Atualiza uma encomenda")
	@PutMapping("/{id}")
	public ResponseEntity<EncomendaDomain> update(@PathVariable Long id, @RequestBody EncomendaDomain encomendaDomain){
		
		encomendaDomain.setId(id);
		encomendaService.update(encomendaDomain);
		return ResponseEntity.noContent().build();
		
	}
	
	private Page<ViewEncomendasDto> convertDto(List<EncomendaDomain> encomenda) {
		return new PageImpl<>(encomenda.stream().map(c -> new ViewEncomendasDto(c)).collect(Collectors.toList())); 
	}
	
}

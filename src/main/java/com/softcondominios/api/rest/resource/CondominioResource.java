package com.softcondominios.api.rest.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

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
import com.softcondominios.api.rest.dto.NewCondominioDto;
import com.softcondominios.api.rest.dto.ViewCondominioDto;
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
	

	
	
	@ApiOperation(value = "Retorna uma lista de condominios")
	@Transactional
	@GetMapping
	public ResponseEntity<Page<ViewCondominioDto>> findAll(Pageable page){
			
		
		Page<ViewCondominioDto> condominio = convertDto(condominioService.findAll(page).getContent());
		
		return ResponseEntity.ok(condominio); 
	
	}
	
	@GetMapping("/search")
	public ResponseEntity<Page<ViewCondominioDto>> findByBairro(@RequestParam(required = false) String bairro, 
																@RequestParam(required = false) String cidade,
																@RequestParam(required = false) String estado,
																@RequestParam(required = false, value = "razao-social") String razaoSocial,
																Pageable pageable){
		
		Page<ViewCondominioDto> condominio = convertDto(condominioService.search(bairro, cidade, estado, razaoSocial, pageable).getContent());
		return ResponseEntity.ok(condominio);
	}
	
	
	@ApiOperation("Cria um condominio")
	@PostMapping
	public ResponseEntity<CondominioDomain> save(@RequestBody NewCondominioDto condominioDto){
	
		
		CondominioDomain condominio = condominioService.save(condominioDto);
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(condominio.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	private Page<ViewCondominioDto> convertDto(List<CondominioDomain> condominio) {
		return new PageImpl<>(condominio.stream().map(c -> new ViewCondominioDto(c)).collect(Collectors.toList())); 
	}
//	private List<ViewCondominioDto> convertDtoList(List<CondominioDomain> condominio) {
//		return condominio.stream().map(c -> new ViewCondominioDto(c)).collect(Collectors.toList()); 
//	}
}

package com.softcondominios.api.rest.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.rest.dto.NewColaboradorDto;
import com.softcondominios.api.rest.dto.ViewColaboradorDto;
import com.softcondominios.api.service.ColaboradorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/colaboradores")
@Api("API Rest colaboradores")
@CrossOrigin(origins = "*")
public class ColaboradorResource {
	@Autowired
	private ColaboradorService colaboradorService;
	

	
	@ApiOperation("Retorna uma lista de colaboradores")
	@GetMapping
	public ResponseEntity<Page<ViewColaboradorDto>> findAll(Pageable page){
			
		
		Page<ViewColaboradorDto> colaboradorDto = convertDto(colaboradorService.findAll(page).getContent());
		return ResponseEntity.ok(colaboradorDto); 
	
	}
	
	@ApiOperation("Pesquisa dinamica")
	@GetMapping("/search")
	public ResponseEntity<Page<ViewColaboradorDto>> search(@RequestParam(required = false) String email,
															Pageable page){
			
		
		Page<ViewColaboradorDto> colaboradorDto = convertDto(colaboradorService.search(email, page).getContent());
		return ResponseEntity.ok(colaboradorDto); 
	
	}
	
	@ApiOperation("Cria Sindicos")
	@PostMapping
	public ResponseEntity<NewColaboradorDto> save(@RequestBody NewColaboradorDto colaborador){
		
		ColaboradorDomain colaboradorDomain = colaboradorService.saveSindico(colaborador);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(colaboradorDomain.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Cria Funcionarios")
	@PostMapping("/funcionarios")
	public ResponseEntity<NewColaboradorDto> saveFuncionarios(@RequestBody NewColaboradorDto colaborador){
		
		ColaboradorDomain colaboradorDomain = colaboradorService.saveFuncionarios(colaborador);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(colaboradorDomain.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@ApiOperation("Retorna colaborador autenticado")
	@GetMapping("/auth")
	public ResponseEntity<ViewColaboradorDto> findByColaborador(){
		 
		 ViewColaboradorDto colaboradorDto = new ViewColaboradorDto(colaboradorService.findByColaborador());
		 return ResponseEntity.ok(colaboradorDto); 
	}
	

	
	
	private Page<ViewColaboradorDto> convertDto(List<ColaboradorDomain> colaborador) {
		return new PageImpl<>(colaborador.stream().map(c -> new ViewColaboradorDto(c)).collect(Collectors.toList())); 
	}
}

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.MensagemDomain;
import com.softcondominios.api.domain.OcorrenciaDomain;
import com.softcondominios.api.rest.dto.NewOcorrenciaDto;
import com.softcondominios.api.rest.dto.ViewOcorrenciaDto;
import com.softcondominios.api.service.OcorrenciaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaResource {

	@Autowired
	private OcorrenciaService ocorrenciaService;
	
	

	@ApiOperation("buscar todas as ocorrencias")
	@GetMapping
	public ResponseEntity<Page<ViewOcorrenciaDto>> findAll(Pageable pageable){
		return ResponseEntity.ok(convertDto(ocorrenciaService.findAll(pageable).getContent()));
	}
	
	@ApiOperation("Busca dinamica")
	@GetMapping("/search")
	public ResponseEntity<Page<ViewOcorrenciaDto>> findAll(@RequestParam(required = false) Boolean status,
														   @RequestParam(required = false) Long condominio,			
												           Pageable pageable){
		return ResponseEntity.ok(convertDto(ocorrenciaService.search(status, condominio, pageable).getContent()));
	}
	
	
	@ApiOperation("Cria uma ocorrencia")
	@PostMapping
	public ResponseEntity<OcorrenciaDomain> save(@RequestBody NewOcorrenciaDto viewOcorrencia){
		
		OcorrenciaDomain o = ocorrenciaService.save(viewOcorrencia);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(o.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@ApiOperation("Cria um comentario")
	@PostMapping("/{id}/comentario")
	public ResponseEntity<OcorrenciaDomain> createComment(@RequestBody MensagemDomain mensagem, @PathVariable Long id){
		
		OcorrenciaDomain o = ocorrenciaService.createComment(id, mensagem);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(o.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
//	@ApiOperation("Edita um visitante")
//	@PutMapping("/{id}")
//	public ResponseEntity<VisitanteDomain> update(@PathVariable Long id, @RequestBody NewVisitanteDto newVisitanteDto){
//		
//		ocorrenciaService.update(newVisitanteDto, id);
//		return ResponseEntity.noContent().build();
//		
//	}
	
	
	
	
	private Page<ViewOcorrenciaDto> convertDto(List<OcorrenciaDomain> ocorrencia) {
		return new PageImpl<>(ocorrencia.stream().map(c -> new ViewOcorrenciaDto(c)).collect(Collectors.toList())); 
	}
}

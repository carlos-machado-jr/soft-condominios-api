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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;
import com.softcondominios.api.rest.dto.NewAgendamentoMudancaDto;
import com.softcondominios.api.rest.dto.ViewAgendamentoMudancaDto;
import com.softcondominios.api.service.AgendamentoMudancaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/agendamentos-mudanca")
public class AgendamentoMudancaResource {
	@Autowired
	private AgendamentoMudancaService agendamentoMudancaService;
	
	@ApiOperation("Retorna uma lista mudancas marcadas")
	@GetMapping
	public ResponseEntity<Page<ViewAgendamentoMudancaDto>> findAll(Pageable pageable){
		Page<ViewAgendamentoMudancaDto> agendamento = convertDtoPage(agendamentoMudancaService.findAll(pageable).getContent());
		return ResponseEntity.ok(agendamento);
		
	}
	
	@ApiOperation("Retorna uma lista mudancas marcadas dinamicamente")
	@GetMapping("/search")
	public ResponseEntity<Page<ViewAgendamentoMudancaDto>> search(
																@RequestParam(required = false) Boolean status,
																@RequestParam(required = false) Long condominio,
																Pageable pageable){
		Page<ViewAgendamentoMudancaDto> agendamento = convertDtoPage(agendamentoMudancaService.search(status, condominio, pageable).getContent());
		return ResponseEntity.ok(agendamento);
		
	}
	
	
	@ApiOperation("Agendar mudanca")
	@PostMapping
	public ResponseEntity<NewAgendamentoMudancaDto> save(@RequestBody NewAgendamentoMudancaDto agendamentoMudancaDto){
		
		AgendamentoMudancaDomain a = agendamentoMudancaService.save(agendamentoMudancaDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(a.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	private Page<ViewAgendamentoMudancaDto> convertDtoPage(List<AgendamentoMudancaDomain> agendamentoMudancaDomain){
		return new PageImpl<>(agendamentoMudancaDomain.stream().map(a -> new ViewAgendamentoMudancaDto(a)).collect(Collectors.toList()));
	}
}

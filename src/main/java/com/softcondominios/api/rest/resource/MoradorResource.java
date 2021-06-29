package com.softcondominios.api.rest.resource;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.repository.CondominioRepository;
import com.softcondominios.api.rest.dto.NewMoradorDto;
import com.softcondominios.api.rest.dto.ViewMoradorDto;
import com.softcondominios.api.service.GrupoPermissaoService;
import com.softcondominios.api.service.MoradorService;
import com.softcondominios.api.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/moradores")
@Api("API Rest moradores")
@CrossOrigin(origins = "*")
public class MoradorResource {
	@Autowired
	private MoradorService moradorService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	@Autowired
	private GrupoPermissaoService grupoPermissaoService;
	
	
	@Autowired
	private CondominioRepository condominioRepository;
	
	
	@ApiOperation("Retorna uma lista de moradores")
	@GetMapping
	public ResponseEntity<Page<ViewMoradorDto>> findAll(Pageable page){
			
		
		Page<ViewMoradorDto> moradorDto = convertDto(moradorService.findAll(page).getContent());
		return ResponseEntity.ok(moradorDto); 
	
	}
	
	
	@ApiOperation("Cria moradores")
	@PostMapping
	public ResponseEntity<NewMoradorDto> save(@RequestBody NewMoradorDto morador, @RequestParam Long condominioId){
		
		MoradorDomain moradorDomain = moradorService.save(createMorador(morador, condominioId));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(moradorDomain.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	private MoradorDomain createMorador(NewMoradorDto newMorador, Long id) {
		
		MoradorDomain morador = new MoradorDomain(newMorador);
		morador.setUsuario(createUser(newMorador));
		morador.setCondominio(condominioRepository.findById(id).orElseThrow(() -> objectNotFoundException("nenhum condominio encontrado")));
		
		return morador;
	}
	
	private UserDomain createUser(NewMoradorDto newMoradorDto) {
		
		UserDomain user = new UserDomain(newMoradorDto);
		user.setGrupoPermissao(findGruposByDescricao("Morador"));
		user.setPassword(criptografarSenha(user.getPassword()));
		
		return userService.save(user);
	}
	
	private String criptografarSenha(String senha) {
		return bCryptPasswordEncoder.encode(senha);
	}
	
	private Set<GrupoPermissaoDomain> findGruposByDescricao(String descricao) {
		
		return convertByHashSet(grupoPermissaoService.findByDescricao(descricao));
	}
	
	private Set<GrupoPermissaoDomain> convertByHashSet(GrupoPermissaoDomain grupoPermissaoDomain){
		Set<GrupoPermissaoDomain> permissao = new HashSet<GrupoPermissaoDomain>();
		permissao.add(grupoPermissaoDomain);
		return permissao;
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

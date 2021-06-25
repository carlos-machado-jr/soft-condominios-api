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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.GrupoPermissaoDomain;
import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.rest.dto.UserDto;
import com.softcondominios.api.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api("API Rest usuario")
@CrossOrigin(origins = "*")
public class UserResource {

	@Autowired
	UserService userService;
	
	@ApiOperation("Retorna uma lista de usuarios")
	@GetMapping
	public ResponseEntity<Page<UserDto>> findAll(Pageable page){
			
		
		Page<UserDto> userdto = convertDto(userService.findAll(page).getContent());
		return ResponseEntity.ok(userdto); 
	
	}
	
	@ApiOperation("Cria um usuario")
	@PostMapping
	public ResponseEntity<UserDomain> save(@RequestBody UserDomain u){
		u.setUserGroup(new GrupoPermissaoDomain("Usuario"));
		UserDomain user = userService.save(u);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	private Page<UserDto> convertDto(List<UserDomain> user) {
		return new PageImpl<>(user.stream().map(u -> new UserDto(u)).collect(Collectors.toList())); 
	}
}

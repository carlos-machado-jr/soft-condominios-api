package com.softcondominios.api.rest.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.UserDomain;
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
	public ResponseEntity<Page<UserDomain>> findAll(Pageable page){
		
		Page<UserDomain> user = userService.findAll(page);
		return ResponseEntity.ok(user); 
	
	}
	
	@ApiOperation("Cria um usuario")
	@PostMapping
	public ResponseEntity<UserDomain> save(@RequestBody UserDomain u){
		UserDomain user = userService.save(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

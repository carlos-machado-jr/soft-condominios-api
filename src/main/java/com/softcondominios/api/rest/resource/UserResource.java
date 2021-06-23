package com.softcondominios.api.rest.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserResource {

	@Autowired
	UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDomain>> findAll(){
		List<UserDomain> user = userService.findAll();
		
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<UserDomain> save(@RequestBody UserDomain u){
		UserDomain user = userService.save(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}

package com.softcondominios.api.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.softcondominios.api.test.DbTeste;

@Configuration
@Profile("dev")
public class DevConfig {
	@Autowired
	private DbTeste dbTeste;
	
	@Bean
	public boolean criarPermissoes() throws ParseException{
		dbTeste.criarPermissoes();
		return true;
	}

}

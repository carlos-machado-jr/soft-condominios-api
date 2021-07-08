package com.softcondominios.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.NotificacaoDomain;
import com.softcondominios.api.repository.NotificacaoRepository;
import com.softcondominios.api.service.specifications.NotificacaoServiceSpecifications;

@Service
public class NotificacaoService extends NotificacaoServiceSpecifications{
	
	
	@Autowired
	private NotificacaoRepository notificacaoRepository;
	
	@Autowired
	private UserService userService;
	
	public NotificacaoDomain save(NotificacaoDomain notificacao) {
		return notificacaoRepository.save(notificacao);
	}
	
	
	
}

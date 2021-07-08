package com.softcondominios.api.service;

import java.util.Objects;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.domain.MensagemDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.domain.OcorrenciaDomain;
import com.softcondominios.api.domain.UserDomain;
import com.softcondominios.api.repository.OcorrenciaRepository;
import com.softcondominios.api.rest.dto.NewOcorrenciaDto;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;
import com.softcondominios.api.service.specifications.OcorrenciaServiceSpecifications;

@Service
public class OcorrenciaService extends OcorrenciaServiceSpecifications{

	@Autowired
	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	private MoradorService moradorService;
	
	
	@Autowired
	private MensagemService mensagemService;
	
	@Autowired
	private UserService userService;
//	
//	@Autowired
//	private NotificacaoService notificacaoService;
	
	public Page<OcorrenciaDomain> findAll(Pageable pageable){
		return ocorrenciaRepository.findAll(pageable);
	}
	
	public Page<OcorrenciaDomain> search(Boolean status, Long condominio, Pageable pageable){
		return ocorrenciaRepository.findAll(searchBy(status, condominio), pageable);
	}
	
	
	public OcorrenciaDomain save(NewOcorrenciaDto newOcorrencia) {
		MoradorDomain morador = moradorService.findByMorador();
		OcorrenciaDomain ocorrencia = new OcorrenciaDomain(newOcorrencia, morador);
		
		
		return ocorrenciaRepository.save(ocorrencia);
	}
	
	@Transactional
	public OcorrenciaDomain createComment(Long id, MensagemDomain mensagem) {
		OcorrenciaDomain ocorrencia = ocorrenciaRepository.findById(id)
														  .orElseThrow(() -> new ObjectNotFoundException("Ocorrencia não encontrada!!"));
		UserDomain user = userService.findUser();
		if(Objects.isNull(user.getMorador())) {
			ColaboradorDomain c = user.getColaborador();
			mensagem.setAutor(c.getNome() + " " + c.getSobrenome());
			
			
		} else {
			MoradorDomain m = user.getMorador();
			mensagem.setAutor(m.getNome() + " " + m.getSobrenome());
			
		}
		
	
		mensagem.setOcorrencia(ocorrencia);
		mensagem.setUsuario(user);
		MensagemDomain m = mensagemService.save(mensagem);
		Set<MensagemDomain> mSet = ocorrencia.getMensagem();
		mSet.add(m);
		
		
		return ocorrenciaRepository.save(ocorrencia);
	}
	
	

}


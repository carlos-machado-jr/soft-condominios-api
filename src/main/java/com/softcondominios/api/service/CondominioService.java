package com.softcondominios.api.service;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softcondominios.api.domain.BairroDomain;
import com.softcondominios.api.domain.CidadeDomain;
import com.softcondominios.api.domain.ColaboradorDomain;
import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.EstadoDomain;
import com.softcondominios.api.repository.CondominioRepository;
import com.softcondominios.api.rest.dto.NewCondominioDto;
import com.softcondominios.api.service.exceptions.ObjectNotFoundException;

@Service
public class CondominioService {
	@Autowired
	private CondominioRepository condominioRepository;
	
	@Autowired
	private BairroService bairroService;
	
	@Autowired 
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	
	
	public Page<CondominioDomain> findAll(Pageable pageable){
		return condominioRepository.findAll(pageable);
	}
	
	
	@Transactional
	public CondominioDomain save(NewCondominioDto newCondominioDto) {
				
		EstadoDomain estado = saveEstado(newCondominioDto.getEstado());
		CidadeDomain cidade = saveCidade(newCondominioDto.getCidade(), estado);
		updateEstado(estado, cidade);
		BairroDomain bairro = saveBairro(newCondominioDto.getBairro(), cidade);
		updateCidade(cidade, bairro);
		
		ColaboradorDomain colaborador = findByColaborador();
		CondominioDomain condominio = convertDto(newCondominioDto, bairro, colaborador);
		updateBairro(bairro, condominio);
		
		
		condominio = condominioRepository.save(condominio);
		updateColaborador(colaborador, condominio);
		
		return condominio;
	}
	
	
	
	
	

	
	
	private Set<ColaboradorDomain> convertToSetObject(ColaboradorDomain object){
		Set<ColaboradorDomain> setObject = new HashSet<>();
		setObject.add(object);
		return setObject;
	}
	
	private void updateColaborador(ColaboradorDomain colaborador, CondominioDomain condominio) {
		Set<CondominioDomain> condominioList = colaborador.getCondominio();
		condominioList.add(condominio);
		colaborador.setCondominio(condominioList);
		
		colaboradorService.update(colaborador);
	}
	
	private ColaboradorDomain findByColaborador() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return colaboradorService.findByEmail(auth.getName());
	}
	
	

	private Set<BairroDomain> convertToSetObject(BairroDomain object){
		Set<BairroDomain> setObject = new HashSet<>();
		setObject.add(object);
		return setObject;
	}
	
	private void updateBairro(BairroDomain bairro, CondominioDomain condominio) {
		bairro.setCondominio(convertToSetObject(condominio));
		bairroService.update(bairro);
	}
	
	private BairroDomain saveBairro(String bairro, CidadeDomain cidade) {
		
		if(bairroService.findByDescricao(bairro) == null) {
			return bairroService.save(new BairroDomain(bairro, cidade));	
		}
		return bairroService.findByDescricao(bairro);
	}
	
	private Set<CidadeDomain> convertToSetObject(CidadeDomain object){
		Set<CidadeDomain> setObject = new HashSet<>();
		setObject.add(object);
		return setObject;
	}
	
	
	private void updateCidade(CidadeDomain cidade, BairroDomain bairro) {
		cidade.setBairroDomain(convertToSetObject(bairro));
		cidadeService.update(cidade);
	}
	
	private CidadeDomain saveCidade(String cidade, EstadoDomain estado) {
		if(cidadeService.findByDescricao(cidade) == null) {
			return cidadeService.save(new CidadeDomain(cidade, estado));
		}
		return cidadeService.findByDescricao(cidade);
	}
	
	
	private void updateEstado(EstadoDomain estado, CidadeDomain cidade) {
		estado.setCidadeDomain(convertToSetObject(cidade));
		estadoService.update(estado);
	}
	private EstadoDomain saveEstado(String estado) {
		if(estadoService.findByUF(estado) == null) {
			return estadoService.save(new EstadoDomain(estado));	
		}
		return  estadoService.findByUF(estado);
	}
	
	
	
	
	private Set<CondominioDomain> convertToSetObject(CondominioDomain object){
		Set<CondominioDomain> setObject = new HashSet<>();
		setObject.add(object);
		return setObject;
	}
	
	private CondominioDomain convertDto(NewCondominioDto newCondominioDto, BairroDomain bairro, ColaboradorDomain colaborador) {
		
		return new CondominioDomain(newCondominioDto, convertToSetObject(colaborador) , bairro);
	}
	
	public CondominioDomain findById(Long id) {
		return condominioRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Condomiminio nao encontrado! Id: " + id + ", Tipo: " + CondominioDomain.class.getName()));
	}
	
}

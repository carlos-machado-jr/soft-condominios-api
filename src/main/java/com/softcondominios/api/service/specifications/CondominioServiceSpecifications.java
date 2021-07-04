package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.softcondominios.api.domain.BairroDomain;
import com.softcondominios.api.domain.CidadeDomain;
import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.EstadoDomain;

public class CondominioServiceSpecifications {
	
	public Specification<CondominioDomain> search(String bairro, String cidade, String estado, String razaoSocial) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(StringUtils.hasText(bairro)) {
				Path<BairroDomain> campo = root.get("bairro");
				Predicate predicado = builder.like(campo.get("descricao"), "%" + bairro + "%");
				predicados.add(predicado);
			}
			if(StringUtils.hasText(cidade)) {
				Path<CidadeDomain> campo = root.get("bairro").get("cidadeDomain");
				Predicate predicado = builder.like(campo.get("descricao"), "%" + cidade + "%");
				predicados.add(predicado);
			}
			if(StringUtils.hasText(estado)) {
				Path<EstadoDomain> campo = root.get("bairro").get("cidadeDomain").get("estadoDomain");
				Predicate predicado = builder.like(campo.get("UF"), "%" + estado + "%");
				predicados.add(predicado);
			}
			if(StringUtils.hasText(razaoSocial)) {
				Path<String> campo = root.get("razaoSocial");
				Predicate predicado = builder.like(campo.get("razaoSocial"), "%" + razaoSocial + "%");
				predicados.add(predicado);
			}
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}

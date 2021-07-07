package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;

public class AgendamentoMudancaServiceSpecifications {
	
	@Transactional
	public Specification<AgendamentoMudancaDomain> searchBy(Boolean status, Long condominio) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(status != null) {
				Path<Boolean> campo = root.get("status");
				Predicate predicado = builder.equal(campo, status);
				predicados.add(predicado);
			}
			
			if(Objects.nonNull(condominio)) {
				Path<Long> campo = root.get("morador").get("condominio");
				Predicate predicado = builder.equal(campo, condominio);
				predicados.add(predicado);
			}
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
	
	@Transactional
	public Specification<AgendamentoMudancaDomain> searchByData(String data) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(StringUtils.hasText(data)) {
				Path<String> campo = root.get("dataHora");
				Predicate predicado = builder.like(campo, "%" + data + "%");
				predicados.add(predicado);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
	
	
}

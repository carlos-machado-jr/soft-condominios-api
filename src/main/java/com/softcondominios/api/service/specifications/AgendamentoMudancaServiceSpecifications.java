package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.softcondominios.api.domain.AgendamentoMudancaDomain;

public class AgendamentoMudancaServiceSpecifications {
	public Specification<AgendamentoMudancaDomain> searchBy(Boolean status, Long condominio) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(status || !status) {
				Path<Boolean> campo = root.get("status");
				Predicate predicado = builder.equal(campo, status);
				predicados.add(predicado);
			}
			
			if(condominio != null) {
				Path<Long> campo = root.get("morador").get("condominio");
				Predicate predicado = builder.equal(campo, condominio);
				predicados.add(predicado);
			}
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
	
}

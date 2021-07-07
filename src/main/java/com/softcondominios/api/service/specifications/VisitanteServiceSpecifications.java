package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.VisitanteDomain;

public class VisitanteServiceSpecifications {
	
	@Transactional
	public Specification<VisitanteDomain> searchBy(Boolean status, Long condominio) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(Objects.nonNull(status)) {
				Path<Boolean> campo = root.get("status");
				Predicate predicado = builder.equal(campo, status );
				predicados.add(predicado);
			}
			
			if(Objects.nonNull(condominio)) {
				Path<CondominioDomain> condominioCampo = root.get("condominio");
				Predicate predicado2 = builder.equal(condominioCampo, condominio );
				predicados.add(predicado2);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}

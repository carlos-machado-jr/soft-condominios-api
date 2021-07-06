package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.softcondominios.api.domain.EncomendaDomain;

public class EncomendaServiceEspecifications {
	
	public Specification<EncomendaDomain> searchBy(Boolean status, Long condominio) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			Path<EncomendaDomain> campo = root.get("status");
			Predicate predicado = builder.equal(campo, status );
			predicados.add(predicado);
			
			if(condominio != null) {
				Path<EncomendaDomain> condominioCampo = root.get("morador").get("condominio");
				Predicate predicado2 = builder.equal(condominioCampo, condominio );
				predicados.add(predicado2);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}

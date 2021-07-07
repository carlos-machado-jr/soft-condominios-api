package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;

import com.softcondominios.api.domain.EncomendaDomain;
import com.softcondominios.api.domain.MoradorDomain;

public class EncomendaServiceEspecifications {
	
	@Transactional
	public Specification<EncomendaDomain> searchBy(Boolean status, Long condominio) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(Objects.nonNull(status)) {
				Path<EncomendaDomain> campo = root.get("status");
				Predicate predicado = builder.equal(campo, status );
				predicados.add(predicado);
			}
			
			if(Objects.nonNull(condominio)) {
				Path<EncomendaDomain> condominioCampo = root.get("morador").get("condominio");
				Predicate predicado2 = builder.equal(condominioCampo, condominio );
				predicados.add(predicado2);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
	
	@Transactional
	public Specification<EncomendaDomain> searchBy(Boolean status, Long condominio, MoradorDomain morador) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(Objects.nonNull(status)) {
				Path<EncomendaDomain> campo = root.get("status");
				Predicate predicado = builder.equal(campo, status );
				predicados.add(predicado);
			}
			
			if(Objects.nonNull(condominio)) {
				Path<EncomendaDomain> condominioCampo = root.get("morador").get("condominio");
				Predicate predicado2 = builder.equal(condominioCampo, condominio );
				predicados.add(predicado2);
			}
			if(Objects.nonNull(morador)) {
				Path<MoradorDomain> campo = root.get("morador");
				Predicate predicado2 = builder.equal(campo, morador );
				predicados.add(predicado2);
			}
			
			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}

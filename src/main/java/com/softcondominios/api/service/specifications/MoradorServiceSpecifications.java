package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.MoradorDomain;

public class MoradorServiceSpecifications {
	
	public Specification<MoradorDomain> search(Long condominio, String nome) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(StringUtils.hasText(nome)) {
				Path<String> campoNome = root.get("nome");
				Predicate predicado = builder.like(campoNome, "%"+nome+"%");
				predicados.add(predicado);
			}
			if(condominio != null) {
				Path<CondominioDomain> condominioCampo = root.get("condominio");
				Predicate predicado = builder.equal(condominioCampo, condominio);
				predicados.add(predicado);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}

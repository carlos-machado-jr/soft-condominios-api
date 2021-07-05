package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.softcondominios.api.domain.ColaboradorDomain;

public class ColaboradorServiceSpecifications {
	
	public Specification<ColaboradorDomain> searchBy(String email) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(StringUtils.hasText(email)) {
				Path<String> campo = root.get("email");
				Predicate predicado = builder.equal(campo, email);
				predicados.add(predicado);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
	
	
}

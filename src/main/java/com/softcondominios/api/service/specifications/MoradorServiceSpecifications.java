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
	
	public Specification<MoradorDomain> searchBy(Long condominio, String nome, String email) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			if(StringUtils.hasText(nome)) {
				Path<String> campo = root.get("nome");
				Predicate predicado = builder.like(campo, "%"+nome+"%");
				predicados.add(predicado);
			}
			if(condominio != null) {
				Path<CondominioDomain> condominioCampo = root.get("condominio");
				Predicate predicado = builder.equal(condominioCampo, condominio);
				predicados.add(predicado);
			}
			if(StringUtils.hasText(email)) {
				Path<String> campo = root.get("email");
				Predicate predicado = builder.equal(campo, email);
				predicados.add(predicado);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
	
	public Specification<MoradorDomain> searchBy( String nomeCompleto) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			String[] nomeSplit = nomeCompleto.split(" ");
			String nome = nomeSplit[0];
			
			String sobrenome = nomeSplit.length > 1 ? nomeSplit[1] : null ;
			
			if(StringUtils.hasText(nome)) {
				Path<String> campo1 = root.get("nome");
				Path<String> campo2 = root.get("sobrenome");
				Predicate predicado = builder.or(builder.like(campo1, "%"+nome+"%"), builder.like(campo2, "%"+nome+"%"));
				
				predicados.add(predicado);
			}
			
			if(StringUtils.hasText(sobrenome)) {
				Path<String> campo1 = root.get("nome");
				Path<String> campo2 = root.get("sobrenome");
				Predicate predicado = builder.or(builder.like(campo1, "%"+sobrenome+"%"), builder.like(campo2, "%"+sobrenome+"%"));
				predicados.add(predicado);
			}
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}

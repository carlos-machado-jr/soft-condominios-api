package com.softcondominios.api.service.specifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.data.jpa.domain.Specification;

import com.softcondominios.api.domain.CondominioDomain;
import com.softcondominios.api.domain.MoradorDomain;
import com.softcondominios.api.domain.UserDomain;

public class UserServiceSpecifications {
	@Transactional
	public Specification<UserDomain> searchBy(Boolean status, Set<CondominioDomain> condominio, String funcao, MoradorDomain morador) {
		
		return (root, query, builder) -> {
			List<Predicate> predicados = new ArrayList<>();
			
			if(Objects.nonNull(status)) {
				Path<Boolean> campo = root.get("status");
				Predicate predicado1 = builder.equal(campo, status );
				predicados.add(predicado1);
			}
			if((funcao.equals("Sindico") || funcao.equals("Morador")) && Objects.nonNull(root.get("colaborador"))) {
				Path<String> funcaoCampo = root.get("colaborador").get("funcao");
				Path<CondominioDomain> condominioCampo = root.get("colaborador").get("condominio");
				Predicate predicado2 = builder.and(builder.equal(funcaoCampo, "Zelador" ), builder.equal(condominioCampo, condominio ));
				predicados.add(predicado2);
			}
			
			if((funcao.equals("Zelador") || funcao.equals("Morador")) && Objects.nonNull(root.get("colaborador"))) {
				Path<String> funcaoCampo = root.get("colaborador").get("funcao");
				Path<Set<CondominioDomain>> condominioCampo = root.get("colaborador").get("condominio");
				Predicate predicado3 = builder.and(builder.equal(funcaoCampo, "Sindico" ), builder.equal(condominioCampo, condominio ));
				predicados.add(predicado3);
			}
	
			
			if((funcao.equals("Zelador") || funcao.equals("Sindico")) && Objects.nonNull(root.get("morador"))) {
				Path<MoradorDomain> moradorCampo = root.get("morador");
				Predicate predicado4 = builder.equal(moradorCampo, morador );
				predicados.add(predicado4);
			}

			
			
			return builder.and(predicados.toArray(new Predicate[0]));
		};
	}
}

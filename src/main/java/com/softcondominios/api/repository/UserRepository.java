package com.softcondominios.api.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.UserDomain;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDomain, Long>, JpaSpecificationExecutor<UserDomain>{

	Optional<UserDomain> findByLogin(String login);

	

}

package com.softcondominios.api.repository;



import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.UserDomain;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserDomain, Long>{

	

}

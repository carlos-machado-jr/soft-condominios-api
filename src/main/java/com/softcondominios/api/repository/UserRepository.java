package com.softcondominios.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softcondominios.api.domain.UserDomain;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long>{

}

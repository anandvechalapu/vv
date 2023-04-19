package com.dsfdfd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsfdfd.login.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Long> { 

	User findByUsername(String username); 

	User findByEmail(String email); 

	boolean existsByUsername(String username); 

	boolean existsByEmail(String email); 

}
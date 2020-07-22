package com.budgetflows.springserverapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.budgetflows.springserverapi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query(nativeQuery = true, value = "SELECT * FROM user WHERE user.email = :email")
	public User findByEmail(@Param("email") String email);
}

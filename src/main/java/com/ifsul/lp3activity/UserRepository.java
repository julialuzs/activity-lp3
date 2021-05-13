package com.ifsul.lp3activity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByUsernameContaining(String username);
	
}

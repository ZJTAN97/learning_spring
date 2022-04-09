package com.learnspring.security.springrestsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.security.springrestsecurity.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	User findByUsername(String username);
}

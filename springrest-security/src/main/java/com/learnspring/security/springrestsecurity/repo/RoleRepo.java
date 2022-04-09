package com.learnspring.security.springrestsecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learnspring.security.springrestsecurity.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	Role findByName(String name);
}

package com.learnspring.security.springrestsecurity.service;

import java.util.List;

import com.learnspring.security.springrestsecurity.entity.Role;
import com.learnspring.security.springrestsecurity.entity.User;

public interface UserService {

	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	List<User> getUsers();
}

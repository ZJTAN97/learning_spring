package com.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.entity.Role;
import com.springboot.entity.User;
import com.springboot.repository.RoleRepository;
import com.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;

	public UserServiceImpl(UserRepository userRepository,
			RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public User saveUser(User user) {
		System.out.println("Saving new user to the database.");
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		System.out.println("Saving new role to the database.");
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepository.findByUsername(username);
		Role role = roleRepository.findByName(roleName);
		user.getRoles().add(role);
		System.out.println("Added role to the user.");
	}

	@Override
	public User getUser(String username) {
		System.out.println("Fetching user.");
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		System.out.println("Fetching all users.");
		return userRepository.findAll();
	}

}

package com.learnspring.security.springrestsecurity.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learnspring.security.springrestsecurity.entity.Role;
import com.learnspring.security.springrestsecurity.entity.User;
import com.learnspring.security.springrestsecurity.repo.RoleRepo;
import com.learnspring.security.springrestsecurity.repo.UserRepo;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	private UserRepo userRepo;
	private RoleRepo roleRepo;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			System.out.println("[Error] User not found in the database.");
			throw new UsernameNotFoundException(
					"User not found in the database");
		} else {
			System.out.println("[INFO] User found in the database");
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

		user.getRoles().forEach(role -> authorities
				.add(new SimpleGrantedAuthority(role.getName())));

		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), authorities);
	}

	public UserServiceImpl(UserRepo theUserRepo, RoleRepo theRoleRepo) {
		userRepo = theUserRepo;
		roleRepo = theRoleRepo;
	}

	@Override
	public User saveUser(User user) {
		System.out.println("[INFO] Saving new user to the database.");
		return userRepo.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		System.out.println("[INFO] Saving new role to the database.");
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
		System.out.println(
				"[INFO] Added role " + roleName + " to user " + username);
	}

	@Override
	public User getUser(String username) {
		System.out.println("[INFO] Fetching user.");
		return userRepo.findByUsername(username);
	}

	@Override
	public List<User> getUsers() {
		System.out.println("[INFO] Fetching all users");
		return userRepo.findAll();
	}

}

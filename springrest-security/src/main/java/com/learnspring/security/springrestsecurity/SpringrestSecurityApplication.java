package com.learnspring.security.springrestsecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learnspring.security.springrestsecurity.entity.Role;
import com.learnspring.security.springrestsecurity.entity.User;
import com.learnspring.security.springrestsecurity.service.UserService;

@SpringBootApplication
public class SpringrestSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringrestSecurityApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService
					.saveUser(new User(null, "Docker", "DockerUser", "1234"));
			userService
					.saveUser(new User(null, "Docker2", "DockerUser2", "1234"));
			userService
					.saveUser(new User(null, "Docker3", "DockerUser3", "1234"));

			userService.addRoleToUser("DockerUser", "ROLE_USER");
			userService.addRoleToUser("DockerUser", "ROLE_MANAGER");
			userService.addRoleToUser("DockerUser", "ROLE_ADMIN");

		};
	}

}

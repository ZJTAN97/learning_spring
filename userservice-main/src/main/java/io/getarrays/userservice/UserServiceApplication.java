package io.getarrays.userservice;

import io.getarrays.userservice.entity.Role;
import io.getarrays.userservice.entity.User;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));


			userService.saveUser(new User(null, "Docker", "Docker", "h6626070",
					new ArrayList<>()));
			userService.saveUser(new User(null, "Spring", "Spring", "h6626070",
					new ArrayList<>()));
			userService.saveUser(new User(null, "React", "React", "h6626070",
					new ArrayList<>()));

			userService.addRoleToUser("Docker", "ROLE_USER");
			userService.addRoleToUser("Docker", "ROLE_ADMIN");
			userService.addRoleToUser("Spring", "ROLE_USER");
		};
	}

}

package com.springboot.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springboot.blog.security.CustomAuthenticationFilter;
import com.springboot.blog.security.CustomAuthorizationFilter;
import com.springboot.blog.security.CustomerUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerUserDetailsService userDetailsService;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(
				authenticationManager());

		customAuthenticationFilter.setFilterProcessesUrl("/api/login");

		http.csrf().disable().exceptionHandling();
		http.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.authorizeRequests().antMatchers("/api/login",
				"/api/token/refresh", "/api/signup").permitAll();

		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/posts")
				.permitAll();
		http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/posts/**/comments")
				.permitAll();

		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/posts")
				.hasAnyAuthority("ROLE_ADMIN");
		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/api/comments")
				.hasAnyAuthority("ROLE_ADMIN");

		http.authorizeRequests().anyRequest().authenticated();

		http.addFilter(customAuthenticationFilter);
		http.addFilterBefore(new CustomAuthorizationFilter(),
				UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager()
			throws Exception {
		return super.authenticationManager();
	}

}

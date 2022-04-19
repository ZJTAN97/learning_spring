package com.springboot.blog.security;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomAuthenticationFilter
		extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public CustomAuthenticationFilter(
			AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		// attempt login + controller
		String username = request.getParameter("usernameOrEmail");
		String password = request.getParameter("password");
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				username, password);
		return authenticationManager.authenticate(authenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain,
			Authentication authentication)
			throws IOException, ServletException {

		// login successful response
		
		User user = (User) authentication.getPrincipal();
		System.out.println("----- Successful authentication! -----");
		System.out.println("Authenticated User: " + user.getUsername());
		System.out.println(user.getAuthorities().toString());

		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
		String access_token = JWT.create().withSubject(user.getUsername())
				.withExpiresAt(
						new Date(System.currentTimeMillis() + 600000))
				.withIssuer(request.getRequestURL().toString())
				.withClaim("roles",
						user.getAuthorities().stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.sign(algorithm);

		Map<String, String> tokens = new HashMap<>();
		tokens.put("access_token", access_token);
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);

		// set httponly cookie for refresh token
		String refresh_token = JWT.create().withSubject(user.getUsername())
				.withExpiresAt(
						new Date(System.currentTimeMillis() + 262980000))
				.withIssuer(request.getRequestURL().toString())
				.sign(algorithm);
		Cookie cookie = new Cookie("refresh", refresh_token);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);

		new ObjectMapper().writeValue(response.getOutputStream(), tokens);

	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException failed)
			throws IOException, ServletException {
		Map<String, String> error = new HashMap<>();
		error.put("error_message", failed.getMessage());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setStatus(HttpStatus.FORBIDDEN.value());
		new ObjectMapper().writeValue(response.getOutputStream(), error);
	}

}

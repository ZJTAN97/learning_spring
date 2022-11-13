package com.security.couponservice.filter;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public Authentication attemptAuthentication(
      HttpServletRequest request,
      HttpServletResponse response
    ) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        System.out.println("[Info] attempting login");
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
          email,
          password
        );
        return authenticationManager.authenticate(authenticationToken);
    }

}

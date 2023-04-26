package com.sample.security.config;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        if ("docker".equals(userName) && "docker".equals(password)) {
            return new UsernamePasswordAuthenticationToken(userName, password, List.of());
        } else {
            log.info("Wrong credentials provided");
            throw new BadCredentialsException("Wrong credentials");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // declare the type of authentication you want
        // example here is Simple UsernamePassword
        // maybe in your own project will include JWT, GoogleAuth etc.
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

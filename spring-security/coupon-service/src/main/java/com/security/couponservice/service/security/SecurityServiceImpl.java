package com.security.couponservice.service.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class SecurityServiceImpl implements SecurityService {

    private final UserDetailsService userDetailsService;

    private final AuthenticationManager authenticationManager;

    @Override
    public boolean login(String username, String password) {

        log.info(username);
        log.info(password);

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token =
          new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        if(token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
        }

        return token.isAuthenticated();
    }
}

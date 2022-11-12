package com.security.couponservice.config;

import com.security.couponservice.service.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
          http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService);
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
          .mvcMatchers(HttpMethod.GET, "/api/coupons/{code:^[A-Z]*$}", "/index", "/showGetCoupon",
            "/getCoupon", "/couponDetails")
          .hasAnyRole("USER", "ADMIN")
          .mvcMatchers(HttpMethod.GET, "/showCreateCoupon", "/createCoupon", "/createResponse")
          .hasRole("ADMIN")
          .mvcMatchers(HttpMethod.POST, "/getCoupon")
          .hasAnyRole("USER", "ADMIN")
          .mvcMatchers(HttpMethod.POST, "/api/coupons", "/saveCoupon", "/getCoupon")
          .hasRole("ADMIN")
          .mvcMatchers("/", "/login", "/logout", "/showReg", "/registerUser")
          .permitAll()
          .anyRequest()
          .denyAll()
          .and()
          .logout()
          .logoutSuccessUrl("/");

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
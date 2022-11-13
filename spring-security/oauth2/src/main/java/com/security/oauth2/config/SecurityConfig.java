package com.security.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
            .anyRequest()
            .authenticated()
          .and()
          .oauth2Login()
          .loginProcessingUrl("/login")
          .loginPage("/oauth2/authorization/google")
          .successHandler(new AuthenticationSuccessHandler() {
              @Override
              public void onAuthenticationSuccess(HttpServletRequest request,
                                                  HttpServletResponse response,
                                                  Authentication authentication)
                throws IOException, ServletException {
                  request.authenticate(response);
              }
          })
          .failureHandler(new AuthenticationFailureHandler() {
              @Override
              public void onAuthenticationFailure(HttpServletRequest request,
                                                  HttpServletResponse response,
                                                  AuthenticationException exception)
                throws IOException, ServletException {
                  // upon failure of logging in and authentication
              }
          });

        //        http.authorizeRequests(
        //          (authorizeRequests) -> authorizeRequests.anyRequest().authenticated()
        //        ).oauth2Login(
        //          (oauth2Customize) -> oauth2Customize
        //            .loginProcessingUrl("/login")
        //            .loginPage("/oauth2/authorization/google")
        //            .successHandler(new AuthenticationSuccessHandler() {
        //                @Override
        //                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        //                    request.authenticate(response);
        //                }
        //            })
        //            .failureHandler(new AuthenticationFailureHandler() {
        //                @Override
        //                public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        //                    // upon failure of logging in and authentication
        //                }
        //            }));

        return http.build();
    }

}

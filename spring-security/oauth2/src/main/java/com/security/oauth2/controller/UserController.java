package com.security.oauth2.controller;

import com.security.oauth2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @PostMapping ("/signup-email")
    public String sample() {


        return "signing up via email";
    }

    @GetMapping("/signup-google")
    public String signup() {
        log.info("hello??");
        return "signed up successfully";
    }

}

package com.security.couponservice.controller;

import com.security.couponservice.model.User;
import com.security.couponservice.repository.UserRepository;
import com.security.couponservice.service.security.WebSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserMvcController {

    private final WebSecurityService securityService;

    private final UserRepository userRepository;


    private final PasswordEncoder encoder;

    @GetMapping("/showReg")
    public String showRegistrationPage() {
        return "registerUser";

    }

    @PostMapping("/registerUser")
    public String register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "login";
    }

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String email, String password) {
        boolean loginResponse = securityService.login(email, password);
        if (loginResponse) {
            return "index";
        }
        return "login";
    }

}

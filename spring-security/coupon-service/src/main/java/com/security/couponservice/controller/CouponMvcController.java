package com.security.couponservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CouponMvcController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

}

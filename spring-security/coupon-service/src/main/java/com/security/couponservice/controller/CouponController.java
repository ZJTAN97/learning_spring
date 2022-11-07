package com.security.couponservice.controller;

import com.security.couponservice.model.Coupon;
import com.security.couponservice.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
@RequiredArgsConstructor
public class CouponController {
    private final CouponRepository couponRepository;

    @PostMapping
    public Coupon create(@RequestBody Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @GetMapping(value = "/{code}")
    public Coupon getCoupon(@PathVariable(value="code") String code) {
        return couponRepository.findByCode(code);
    }

}

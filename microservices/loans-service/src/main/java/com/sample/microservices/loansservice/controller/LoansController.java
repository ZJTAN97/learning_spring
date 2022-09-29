package com.sample.microservices.loansservice.controller;

import com.sample.microservices.loansservice.config.LoansServiceConfig;
import com.sample.microservices.loansservice.model.Customer;
import com.sample.microservices.loansservice.model.Loans;
import com.sample.microservices.loansservice.repository.LoansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    LoansServiceConfig loansServiceConfig;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestBody Customer customer) {
        return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
    }

    @GetMapping("/loans/properties")
    public String getLoansProperties() {
        return loansServiceConfig.toString();
    }

}

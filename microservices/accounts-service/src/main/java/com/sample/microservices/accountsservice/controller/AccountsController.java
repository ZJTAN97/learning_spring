package com.sample.microservices.accountsservice.controller;

import com.sample.microservices.accountsservice.config.AccountsServiceConfig;
import com.sample.microservices.accountsservice.model.Accounts;
import com.sample.microservices.accountsservice.model.Customer;
import com.sample.microservices.accountsservice.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountsServiceConfig accountsServiceConfig;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        return accountsRepository.findByCustomerId(customer.getCustomerId());
    }

    @GetMapping("/account/properties")
    public String getAccountProperties() {
        return accountsServiceConfig.toString();
    }

}

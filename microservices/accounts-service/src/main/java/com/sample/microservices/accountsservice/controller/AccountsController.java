package com.sample.microservices.accountsservice.controller;

import com.sample.microservices.accountsservice.client.CardsFeignClient;
import com.sample.microservices.accountsservice.client.LoansFeignClient;
import com.sample.microservices.accountsservice.config.AccountsServiceConfig;
import com.sample.microservices.accountsservice.model.*;
import com.sample.microservices.accountsservice.repository.AccountsRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class AccountsController {

    private final AccountsRepository accountsRepository;

    private final AccountsServiceConfig accountsServiceConfig;

    private final LoansFeignClient loansFeignClient;

    private final CardsFeignClient cardsFeignClient;

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {
        return accountsRepository.findByCustomerId(customer.getCustomerId());
    }

    @GetMapping("/account/properties")
    public String getAccountProperties() {
        return accountsServiceConfig.toString();
    }

    @PostMapping("/myCustomerDetails")
    public CustomerDetails myCustomerDetails(@RequestBody Customer customer) {

        Accounts accounts =
          accountsRepository.findByCustomerId(customer.getCustomerId());

        List<Loans> loans = loansFeignClient.getLoansDetails(customer);

        List<Cards> cards = cardsFeignClient.getCardDetails(customer);

        return CustomerDetails
          .builder()
          .accounts(accounts)
          .loans(loans)
          .cards(cards)
          .build();

    }

}

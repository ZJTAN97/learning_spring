package com.sample.microservices.accountsservice.controller;

import com.sample.microservices.accountsservice.client.CardsFeignClient;
import com.sample.microservices.accountsservice.client.LoansFeignClient;
import com.sample.microservices.accountsservice.config.AccountsServiceConfig;
import com.sample.microservices.accountsservice.model.*;
import com.sample.microservices.accountsservice.repository.AccountsRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
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
//    @CircuitBreaker(name = "detailsForCustomerSupportApp", fallbackMethod =
//      "myCustomerDetailsFallBack")
    @Retry(name = "retryForCustomerDetails", fallbackMethod =
      "myCustomerDetailsFallback")
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

    @GetMapping("/sayHello")
    @RateLimiter(name= "sayHello", fallbackMethod = "sayHelloFallback")
    public String sayHello() {
        return "Welcome to sample bank application backend";
    }

    private String sayHelloFallback(Throwable t) {
        return "You spammed too much.";
    }

    private CustomerDetails myCustomerDetailsFallBack(Customer customer,
                                                      Throwable t) {
        Accounts accounts =
          accountsRepository.findByCustomerId(customer.getCustomerId());
        List<Loans> loans = loansFeignClient.getLoansDetails(customer);
        return CustomerDetails
          .builder()
          .accounts(accounts)
          .loans(loans)
          .build();
    }


}

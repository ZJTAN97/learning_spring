package com.sample.microservices.accountsservice.client;

import com.sample.microservices.accountsservice.model.Customer;
import com.sample.microservices.accountsservice.model.Loans;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {

    @PostMapping(value = "myLoans", consumes = "application/json")
    List<Loans> getLoansDetails(@RequestBody Customer customer);

}

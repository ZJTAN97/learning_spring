package com.sample.microservices.loansservice.controller;

import com.sample.microservices.loansservice.config.LoansServiceConfig;
import com.sample.microservices.loansservice.model.Customer;
import com.sample.microservices.loansservice.model.Loans;
import com.sample.microservices.loansservice.repository.LoansRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoansRepository loansRepository;

    private final LoansServiceConfig loansServiceConfig;

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(
      @RequestHeader("bank-correlation-id") String correlationId,
      @RequestBody Customer customer) {
        return loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
    }

    @GetMapping("/loans/properties")
    public String getLoansProperties() {
        return loansServiceConfig.toString();
    }

}

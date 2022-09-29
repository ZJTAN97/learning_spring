package com.sample.microservices.accountsservice.client;

import com.sample.microservices.accountsservice.model.Cards;
import com.sample.microservices.accountsservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient("cards")
public interface CardsFeignClient {

    @PostMapping(value = "myCards", consumes = "application/json")
    List<Cards> getCardDetails(@RequestHeader("bank-correlation-id") String correlationId, @RequestBody Customer customer);

}

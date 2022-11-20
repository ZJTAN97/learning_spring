package com.sample.microservices.cardsservice.controller;

import com.sample.microservices.cardsservice.model.Cards;
import com.sample.microservices.cardsservice.model.Customer;
import com.sample.microservices.cardsservice.repository.CardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardsRepository cardsRepository;

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(@RequestBody Customer customer) {
        return cardsRepository.findByCustomerId(customer.getCustomerId());
    }

}

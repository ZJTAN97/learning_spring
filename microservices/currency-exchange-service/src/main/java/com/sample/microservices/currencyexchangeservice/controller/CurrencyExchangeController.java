package com.sample.microservices.currencyexchangeservice.controller;

import com.sample.microservices.currencyexchangeservice.entity.CurrencyExchange;
import com.sample.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
      @PathVariable String from,
      @PathVariable String to
    ) {

        CurrencyExchange currencyExchange =
          currencyExchangeRepository.findByFromAndTo(from, to);

        currencyExchange.setEnvironment(environment.getProperty("local" +
          ".server.port"));

        return currencyExchange;
    }

}

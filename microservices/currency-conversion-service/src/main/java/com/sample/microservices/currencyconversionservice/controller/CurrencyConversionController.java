package com.sample.microservices.currencyconversionservice.controller;

import com.sample.microservices.currencyconversionservice.config.CurrencyExchangeProxy;
import com.sample.microservices.currencyconversionservice.entity.CurrencyConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity" +
      "/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
      @PathVariable String from,
      @PathVariable String to,
      @PathVariable BigDecimal quantity
    ) {

        CurrencyConversion currencyConversion =
          proxy.retrieveExchangeValue(from, to);

        return CurrencyConversion.builder()
          .id(1000L)
          .from(from)
          .to(to)
          .quantity(quantity)
          .conversionMultiple(currencyConversion.getConversionMultiple())
          .environment(currencyConversion.getEnvironment())
          .totalCalculatedAmount(quantity.multiply(currencyConversion.getConversionMultiple()))
          .build();

    }

}

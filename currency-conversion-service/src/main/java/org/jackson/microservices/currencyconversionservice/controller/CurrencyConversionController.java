package org.jackson.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.Random;

import org.jackson.microservices.currencyconversionservice.command.CurrencyConversionBean;
import org.jackson.microservices.currencyconversionservice.command.ExchangeValue;
import org.jackson.microservices.currencyconversionservice.service.proxy.CurrencyExchangeServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-converter")
public class CurrencyConversionController {
	public static Logger logger = LoggerFactory.getLogger(CurrencyConversionController.class);
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;
	@GetMapping("/from/{fromCountry}/to/{toCountry}/quantity/{quantity}")
	public CurrencyConversionBean getConvertedCurrency(@PathVariable("fromCountry")String fromCountry, @PathVariable("toCountry")String toCountry, @PathVariable("quantity")Integer quantity) {
		ExchangeValue exchangeValue = currencyExchangeServiceProxy.getExchangeValue(fromCountry, toCountry);
		logger.info("Exhange Value In CurrencyConversionController-> {}", exchangeValue);
		return new CurrencyConversionBean(new Random(100000000000L).nextLong(), fromCountry, toCountry, exchangeValue.getConversionMultiple(), quantity, BigDecimal.valueOf(quantity*exchangeValue.getConversionMultiple().doubleValue()),exchangeValue.getPort());
	}
}

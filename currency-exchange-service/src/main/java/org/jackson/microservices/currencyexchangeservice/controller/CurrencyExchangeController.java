package org.jackson.microservices.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.util.Random;

import org.jackson.microservices.currencyexchangeservice.command.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {
	public static Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
	@Autowired
	private Environment environment;
	@GetMapping(value = "/from/{fromCountry}/to/{toCountry}")
	public ExchangeValue getExchangeValue(@PathVariable("fromCountry")String fromCountry, @PathVariable("toCountry")String toCountry) {
		Integer port = Integer.parseInt(environment.getProperty("server.port"));
		logger.info("From Country -> {} To Country -> {}", fromCountry,toCountry);
		if("USD".equals(toCountry)) {
			return new ExchangeValue(new Random(100000000000L).nextLong(), fromCountry, toCountry, BigDecimal.valueOf(65),port);
		} else if("EU".equals(toCountry)) {
			return new ExchangeValue(new Random(100000000000L).nextLong(), fromCountry, toCountry, BigDecimal.valueOf(68),port);
		} else if("CNY".equals(toCountry)) {
			return new ExchangeValue(new Random(100000000000L).nextLong(), fromCountry, toCountry, BigDecimal.valueOf(40),port);
		} else {
			return new ExchangeValue(new Random(100000000000L).nextLong(), fromCountry, toCountry, BigDecimal.valueOf(1),port);
		}
	}
}

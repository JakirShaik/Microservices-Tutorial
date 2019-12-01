package org.jackson.microservices.currencyconversionservice.service.proxy;

import org.jackson.microservices.currencyconversionservice.command.ExchangeValue;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
@RequestMapping("/currency-exchange-service/currency-exchange")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/from/{fromCountry}/to/{toCountry}")
	public ExchangeValue getExchangeValue(@PathVariable("fromCountry")String fromCountry, @PathVariable("toCountry")String toCountry);
}

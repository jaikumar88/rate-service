/**
 * 
 */
package com.ntss.rate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntss.rate.service.RateService;

/**
 * @author Owner
 *
 */
@RestController
public class RateController {
	
	private final RateService rateService;
	public RateController(final RateService rateService) {
		this.rateService = rateService;
	}
	
	@GetMapping("/welcome")
	public String welcomeMesseage() {
		double rate = rateService.calculateRate();
		return " Welcome to SpringBoot" + rate;
	}
	
	
	

}

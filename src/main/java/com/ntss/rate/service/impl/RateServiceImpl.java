package com.ntss.rate.service.impl;

import org.springframework.stereotype.Service;

import com.ntss.rate.repository.RateRepository;
import com.ntss.rate.service.RateService;

@Service
public class RateServiceImpl implements RateService {

	private final RateRepository rateRepository;
	public RateServiceImpl(final RateRepository rateRepository) {
		this.rateRepository = rateRepository;
	}
	@Override
	public double calculateRate() {
		
		return rateRepository.calculatePrice();
	}
	
	

}

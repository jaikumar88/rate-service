/**
 * 
 */
package com.ntss.rate.repository.impl;

import org.springframework.stereotype.Repository;

import com.ntss.rate.repository.RateRepository;

/**
 * @author Owner
 *
 */
@Repository
public class RateRepositoryImpl implements RateRepository {

	@Override
	public double calculatePrice() {
		// TODO Auto-generated method stub
		return 5.0;
	}

}

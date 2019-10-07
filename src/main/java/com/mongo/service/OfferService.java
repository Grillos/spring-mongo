package com.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.domain.Offers;
import com.mongo.repository.OfferRepository;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	public List<Offers> find() {
				
		return offerRepository.findAll();
	}
	
	public void save(Offers offers) {
		offerRepository.save(offers);
	}
	
}

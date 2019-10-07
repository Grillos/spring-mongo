package com.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.domain.Offers;

public interface OfferRepository extends MongoRepository<Offers, Long> {

}

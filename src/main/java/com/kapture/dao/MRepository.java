package com.kapture.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kapture.model.RequstData;

public interface MRepository extends MongoRepository<RequstData, Integer> {
	
}

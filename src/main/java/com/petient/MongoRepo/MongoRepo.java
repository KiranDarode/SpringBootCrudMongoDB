package com.petient.MongoRepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.petient.entits.Patient;

public interface MongoRepo extends MongoRepository<Patient, Integer> {
	

}

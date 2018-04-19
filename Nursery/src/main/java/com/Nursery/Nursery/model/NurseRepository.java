package com.Nursery.Nursery.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NurseRepository extends MongoRepository<Patient,String> {

}

package com.atos.api.repositories;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.atos.api.entities.Resource;

@Service
public interface ResourceRepository extends MongoRepository<Resource, ObjectId>{
	Optional<Resource> findById(ObjectId Id);
	void deleteById(ObjectId id);
}

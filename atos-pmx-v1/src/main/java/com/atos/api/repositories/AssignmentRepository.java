package com.atos.api.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.atos.api.entities.Assignment;

@Service
public interface AssignmentRepository extends MongoRepository<Assignment, ObjectId>{
	Assignment findByAssignmentId(ObjectId id);
}

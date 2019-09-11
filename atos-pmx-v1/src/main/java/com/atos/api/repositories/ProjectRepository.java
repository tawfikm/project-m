package com.atos.api.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.atos.api.entities.Project;

@Service
public interface ProjectRepository extends MongoRepository<Project, ObjectId>{
	
	Project findByObjId(ObjectId  id);
	
}

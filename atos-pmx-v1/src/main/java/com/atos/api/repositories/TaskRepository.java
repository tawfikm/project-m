package com.atos.api.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.atos.api.entities.Task;

@Service
public interface TaskRepository extends MongoRepository<Task, ObjectId>{
//	Task findByObjId(String objId);
//	Task findByIdt(int id);
	Task findByIdt(Integer id);
	Task findByName(String name);
}

package com.atos.api.web;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atos.api.entities.Assignment;
import com.atos.api.repositories.AssignmentRepository;

@RestController
@RequestMapping("/assignments")
public class AssignmnetController {
  @Autowired
  private AssignmentRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Assignment> getAllAssignments() {
    return repository.findAll();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Assignment getAssignmentById(@PathVariable("id") ObjectId id) {
    return repository.findByAssignmentId(id);
  }
  
  @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
  public void modifyAssignmentById(@PathVariable("id") ObjectId id, @RequestBody Assignment as) {
	  as.setAssignmentId(id);
	  repository.save(as);
  }
  
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Assignment createAssignment(@RequestBody Assignment as) {
    as.setAssignmentId(ObjectId.get());
    repository.save(as);
    return as;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteAssignment(@PathVariable ObjectId id) {
    repository.delete(repository.findByAssignmentId(id));
  }
  
}

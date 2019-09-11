package com.atos.api.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atos.api.entities.Resource;
import com.atos.api.repositories.ResourceRepository;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/resources")
public class ResourceController {
  @Autowired
  private ResourceRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Resource> getAllResources() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Optional<Resource> getResourceById(@PathVariable("id") ObjectId id) {
    return repository.findById(id);
  }
  
  @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
  public void modifyResourceById(@PathVariable("id") ObjectId id, @Valid @RequestBody Resource res) {
    res.setId(id);
    repository.save(res);
  }
  
  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public Resource createResource(@RequestBody Resource res) {
    res.setId(ObjectId.get());
    repository.save(res);
    return res;
  }
  
  @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
  public void deleteResource(@PathVariable ObjectId id) {
    repository.deleteById(id);
  }
}
	
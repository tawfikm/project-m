package com.atos.api.web;


import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atos.api.AtosPmxApplication;
import com.atos.api.entities.Project;
import com.atos.api.entities.Task;
import com.atos.api.repositories.ProjectRepository;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/projects")
public class ProjectController {
	@Autowired
	private ProjectRepository projectRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(AtosPmxApplication.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Project saveProject(@RequestBody Project p) {
		p.setObjId(ObjectId.get());
		return projectRepository.save(p);
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
	public void modifyProject(@PathVariable("id") ObjectId id, @RequestBody Project p) {
		p.setObjId(id);
		projectRepository.save(p);
	}
	
	@RequestMapping(value = "/{id}/tasks", method = RequestMethod.GET)
	public List<Task> getChartdata(@PathVariable("id") String id) {
		List<Task> tasks = new ArrayList<>();
		ObjectId toId = new ObjectId(id);
//		logger.info("id Value from getChartdata: {}", toId.toHexString());
		Project project = projectRepository.findByObjId(toId);
		
		project.getTasks().forEach(e->{
			if(e.getDuration()!= null)
				tasks.add(e);
		});
		
		return tasks;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Project getProjectById(@PathVariable("id") ObjectId id) {
		return projectRepository.findByObjId(id);
	}	
	
	@RequestMapping(value = "update/{id}/addTask", method = RequestMethod.PUT)
	public void addNewTask(@PathVariable("id") ObjectId id, @RequestBody Task t) {
		Project project = projectRepository.findByObjId(id);
		t.setIdt(new ObjectId());
		project.getTasks().add(t);
		projectRepository.save(project);
	}
	
	@RequestMapping(value = "update/{id}/updateTask/{idt}", method = RequestMethod.PUT)
	public void updateTaskInProject(@PathVariable("id") ObjectId id, @RequestBody Task t, @PathVariable("idt") ObjectId idt) {
		logger.info("updating task in porject");
		Project project = projectRepository.findByObjId(id);
		List<Task> tasks = project.getTasks();
		Task tache = new Task(); 
		for (Task task : tasks) {
			if(task.getIdt().equals(idt.toHexString()))
				{		
				tache = task;
				break;} 
		}
		t.setIdt(idt);
		tasks.remove(tache);
		tasks.add(t);
		projectRepository.save(project);
	}

	
	@RequestMapping(value = "update/{id}/deleteTask/{idt}", method = RequestMethod.DELETE)
	public void deleteTask(@PathVariable("id") ObjectId id, @PathVariable("idt") String idt) {
		logger.info("do delete task: ", idt);
		Project project = projectRepository.findByObjId(id);
		List<Task> tasks = project.getTasks();
		Task t = new Task(); 
		for (Task task : tasks) {
			if(task.getIdt().equals(idt))
				{		
						t = task; break;} 
		}
		tasks.remove(t);
		projectRepository.save(project);
	}
	

	@RequestMapping(value = "{id}/delete", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable("id") ObjectId id) {
		projectRepository.deleteById(id);
	}
}

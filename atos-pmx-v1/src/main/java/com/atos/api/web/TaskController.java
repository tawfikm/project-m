package com.atos.api.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atos.api.entities.Project;
import com.atos.api.entities.Task;
import com.atos.api.repositories.ProjectRepository;
import com.atos.api.repositories.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private ProjectRepository projectRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Task> getAllTasks() {
		return taskRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Task getTaskById(@PathVariable("id") Integer id) {
		return taskRepository.findByIdt(id);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void modifyTaskById(@RequestBody Task t) {
		t.setIdt(new ObjectId().toHexString());
		taskRepository.save(t);
	}

	

	@RequestMapping(value = "/save/{projectId}", method = RequestMethod.POST)
	public Task createTask(@PathVariable("projectId") ObjectId projectId, @RequestBody Task t) {
		// t.setObjId(ObjectId.get());
		Project project = projectRepository.findByObjId(projectId);
		project.getTasks().add(t);
		taskRepository.save(t);
		projectRepository.save(project);
		return t;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteTask(@PathVariable Integer id) {
		taskRepository.delete(taskRepository.findByIdt(id));
	}
}

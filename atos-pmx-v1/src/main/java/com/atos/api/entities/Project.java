package com.atos.api.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import net.sf.mpxj.ProjectFile;

@Document(collection = "projects")
public class Project {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	ObjectId objId;

	private String projectTitle;
	private String projectManager;
	private String description;
	private Date dateCreation;

	List<Resource> resources = new ArrayList<>();
	List<Task> tasks = new ArrayList<>();
	List<Assignment> assignments = new ArrayList<>();

	public Project() {
	}

	public Project(ProjectFile projectFile) {
		fillProjectInfo(projectFile);

		for (net.sf.mpxj.Resource r : projectFile.getResources()) {
			Resource res = new Resource(r);
			resources.add(res);
		}

		for (net.sf.mpxj.ResourceAssignment r : projectFile.getResourceAssignments()) {
			Assignment resAss = new Assignment(r);
			assignments.add(resAss);
		}
		for (net.sf.mpxj.Task t : projectFile.getTasks()) {
			Task ta = new Task(t);
			tasks.add(ta);
		}
	}

	private void fillProjectInfo(ProjectFile project) {
		this.setProjectTitle(project.getProjectProperties().getProjectTitle());
		this.setProjectManager(project.getProjectProperties().getAuthor());
	}

	
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public String getObjId() {
		return objId.toHexString();
	}

	public void setObjId(ObjectId objId) {
		this.objId = objId;
	}

}

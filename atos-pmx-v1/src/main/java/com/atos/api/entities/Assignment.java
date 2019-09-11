package com.atos.api.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import net.sf.mpxj.ResourceAssignment;

@Document(collection = "assignments")
public class Assignment {
	
	@Id
	private ObjectId assignmentId;
	
	public String getAssignmentId() {
		return assignmentId.toHexString();
	}

	public void setAssignmentId(ObjectId assignmentId) {
		this.assignmentId = assignmentId;
	}

	private String taskId;
	private String resourceId;


	public Assignment() {
	}

	
	public Assignment(String taskId, String resourceId) {
		super();
		this.taskId = taskId;
		this.resourceId = resourceId;
	}

	public Assignment(ResourceAssignment resourceAssignment) {
		
//		this.setResourceId(resourceAssignment.getResource().getID());
//		this.setResourceUniqueId(resourceAssignment.getResourceUniqueID());
//		this.setTaskUniqueId(resourceAssignment.getTaskUniqueID());
//		this.setTaskId(resourceAssignment.getTask().getID());
//
//		if (resourceAssignment.getResource() == null) {
//			this.setResourceId(null);
//		} else
//			this.setResourceId(resourceAssignment.getResource().getID());

	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}



	

}

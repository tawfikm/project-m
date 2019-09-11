package com.atos.api.entities;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "resources")
public class Resource {

	@Id
	private ObjectId id;
	private boolean isActive = false;
	private String name;
	private String type;
	private String speciality;
	private String email;
	
	public Resource() {
	}
	public Resource(String name, String speciality, String email) {
		super();
		this.name = name;
		this.speciality = speciality;
		this.email = email;
	}
	public Resource(net.sf.mpxj.Resource resource) {
//		this.setId(resource.getID());
//		if (resource.getName() == null) {
//			this.setName("Unassigned Resource");
//		} else {
//			this.setName(resource.getName());
//		}
//		this.setUniqueId(resource.getUniqueID());
//		this.setType(resource.getType().name());
	}



	// ID in the project which also shows the order of the resource
	// unique ID
	private Integer uniqueId;



	
	@Override
	public String toString() {
		return "Resource [id=" + id + ", isActive=" + isActive + ", name=" + name + ", speciality=" + speciality + "]";
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id.toHexString();
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	

}

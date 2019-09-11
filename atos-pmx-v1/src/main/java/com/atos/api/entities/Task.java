package com.atos.api.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.atos.api.util.Utils;

import net.sf.mpxj.ProjectCalendar;

@Document(collection = "tasks")
public class Task {
	// @Id
	// ObjectId objId;
	@Id
	private ObjectId idt;
	private String name;
	private Integer uniqueId;
	private boolean active;
	private Number percentageComplete;
	private Date startDate;
	private Date finishDate;
	private Number duration;
	private String predecessors;
	private List<String> resources = new ArrayList<>();

	public Task() {
	}

	
	public Task(String name, Number percentageComplete, Date startDate, Date finishDate, Number duration) {
		super();
		this.idt = new ObjectId();
		this.name = name;
		this.percentageComplete = percentageComplete;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.duration = duration;
	}


	public Task(net.sf.mpxj.Task task) {
		ProjectCalendar calendar = task.getEffectiveCalendar();
//		this.setIdt(task.getID().toString());
		this.setUniqueId(task.getUniqueID());
		this.setActive(task.getActive());
		this.setPercentageComplete(task.getPercentageComplete());
		this.setName(task.getName());
		this.setStartDate(task.getStart());

		if (task.getDuration() != null) {
//			this.setDuration(task.getDuration().toString());
			Date finDate = calendar.getDate(task.getStart(), task.getDuration(), false);
			this.setFinishDate(finDate);
			this.setResources(Utils.getDirectResources(task));

		} else
			this.setDuration(null);
		
		this.setPredecessors(Utils.getDirectDependingTasks(task));


	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdt() {
		return idt.toHexString();
	}

	public void setIdt(ObjectId idt) {
		this.idt = idt;
	}

	public Integer getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(Integer uniqueId) {
		this.uniqueId = uniqueId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Number getPercentageComplete() {
		return percentageComplete;
	}

	public void setPercentageComplete(Number percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	public Number getDuration() {
		return duration;
	}

	public void setDuration(Number duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Task [idt=" + idt + ", name=" + name + ", uniqueId=" + uniqueId + ", active=" + active
				+ ", percentageComplete=" + percentageComplete + ", StartDate=" + startDate + ", finishDate="
				+ finishDate + "predecessors=" + predecessors +"]";
	}

	public String getPredecessors() {
		return predecessors;
	}

	public List<String> getResources() {
		return resources;
	}

	public void setResources(List<String> listRes) {
		this.resources = listRes;
	}

	public void setPredecessors(String predecessors) {
		this.predecessors = predecessors;
	}

}

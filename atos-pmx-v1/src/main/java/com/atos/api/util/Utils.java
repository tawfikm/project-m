package com.atos.api.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.mpxj.Relation;
import net.sf.mpxj.ResourceAssignment;
import net.sf.mpxj.Task;

public class Utils {

	public static String getDirectDependingTasks(Task task) {
		List<String> relations = new ArrayList<>();
		for (Relation relation : task.getPredecessors()) {
			relations.add(String.valueOf(relation.getTargetTask().getID()));
		}
		return String.join(", ", relations);

	}

	public static List<String> getDirectResources(Task task) {
		List<String> listRes = new ArrayList<>();

		for (ResourceAssignment ra : task.getResourceAssignments()) {
			listRes.add(ra.getResource().getName());
		}
		return listRes;
	}

}

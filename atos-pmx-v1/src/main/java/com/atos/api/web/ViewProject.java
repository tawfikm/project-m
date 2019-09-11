package com.atos.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/views")
public class ViewProject {

	@RequestMapping(value = "/addTask", method = RequestMethod.GET)
	public String addNewTaskhtml() {
		return "saveTask.html";
	}
}

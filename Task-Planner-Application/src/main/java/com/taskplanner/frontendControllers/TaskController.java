package com.taskplanner.frontendControllers;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
class TaskController{
	
	@RequestMapping("/home")
	public  String  homepage() {
	
		return "hometask.html";
	}
	
	
	@RequestMapping("/")
	public  String getalltask() {
	
		return "allTask.html";
	}
	
	

	@RequestMapping("/createSprint")
	public  String  logout() {
	
		return "createSprint.html";
	}
	

	@RequestMapping("/saveTask")
	public  String  saveYourTask() {
	
		return "saveTask.html";
	}
	
	
	

	@RequestMapping("/getAllSprint")
	public  String  getAllSprint() {
	
		return "getAllSprint.html";
	}

	@RequestMapping("/getAllTask")
	public  String  getAllTask() {
	
		return "getAllTask.html";
	}

}
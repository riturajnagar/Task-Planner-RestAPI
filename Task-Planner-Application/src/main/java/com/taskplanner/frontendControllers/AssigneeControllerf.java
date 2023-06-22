package com.taskplanner.frontendControllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskplanner.entities.Assignee;
import com.taskplanner.services.AssigneeService;

@Controller
public class AssigneeControllerf {
	
	@Autowired
	private AssigneeService as;
	
	
//	@PostMapping("/saveAssigne")
//	public String saveAssigneeHandler(@ModelAttribute Assignee assignee, HttpSession session){
//		
//		String str=as.saveAssignee(assignee);
//		
//	
//		session.setAttribute("msg", "register successfully. ");
//		System.out.println(str);
//		
//		return "registerAssignee";
//	}

	@RequestMapping("/saveAssigne")
	public  String  register() {
	
		return "registerAssignee.html";
	}
	

	@RequestMapping("/getAllAssignee")
	public  String  getAllAssignee() {
	
		return "getAllAssignee.html";
	}
	
	
	
}

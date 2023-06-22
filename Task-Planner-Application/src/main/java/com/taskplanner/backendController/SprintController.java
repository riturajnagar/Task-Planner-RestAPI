package com.taskplanner.backendController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.taskplanner.entities.Sprint;
import com.taskplanner.entities.Task;
import com.taskplanner.exceptions.NoSprintAvailableException;
import com.taskplanner.services.SprintService;

@RestController
@RequestMapping("/api")
public class SprintController {

	 @Autowired
	 private SprintService ss;
	
	@PostMapping("/addsprint")
	public ResponseEntity<String> addasSprintHandler(@RequestBody @Valid Sprint sprint){
		String str=ss.saveSprint(sprint);
		 
		return new ResponseEntity<>(str, HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/deletesprint/{id}")
	public ResponseEntity<String> deleteSprintHandler(@PathVariable Integer id) throws NoSprintAvailableException{
		String str=ss.deleteSprint(id);
		 
		return new ResponseEntity<>(str, HttpStatus.OK);
	}


	@GetMapping("/getaallAssignedTaskinSprint/{id}")
    public ResponseEntity<List<Task>> getAllAssigndTaskinSprint(@PathVariable Integer id){
   	 List<Task> li=ss.getallAssignedTaskInThisSprint(id);
   	 
   	 return new ResponseEntity<List<Task>>(li,HttpStatus.ACCEPTED);
    }
	
	
}
